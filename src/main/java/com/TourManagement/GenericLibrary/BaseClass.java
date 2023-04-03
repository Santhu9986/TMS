package com.TourManagement.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.TourManagement.GenericLibrary.ListnerImplementation.class)
public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS()
	{
		try 
		{
			Reporter.log("---Connect to DB---", true);
			DatabaseUtility.connectToDB();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC()
	{	
		try 
		{
			Reporter.log("---Open Browser---", true);
			String BROWSER = FileUtility.getPropertyValue("browser");
					
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);

			}
			
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver(options);
			}
		
			else
			{
				System.out.println("Invalid browser name");
			}
			sdriver = driver;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM()
	{
		WebDriverUtility.maximizeWindow(driver);
		
		driver.get(FileUtility.getPropertyValue("url"));
	
		WebDriverUtility.waitForImplicit(driver);
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM(ITestResult result)
	{
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		try {	
			driver.quit();
			Reporter.log("-----Closed Browser----",true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS()
	{
		try {
			Reporter.log("-----Closed DB----",true);
			DatabaseUtility.closeDB();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
