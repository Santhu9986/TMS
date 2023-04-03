package com.TourManagement.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.WebDriverUtility;

public class PackageListPage {
	WebDriver driver;
	
	@FindBy(xpath = "//img")
	private List<WebElement> imageList;
	
	@FindBy(xpath = "//h4")
	private List<WebElement> packageNameList;
	
	@FindBy(xpath = "//h6")
	private List<WebElement> packageTypeList;
	
	@FindBy(xpath = "//b[.='Package Location :']/parent::p")
	private List<WebElement> packageLocationList;
	
	@FindBy(xpath = "//b[.='Features']/parent::p")
	private List<WebElement> featuresList;
	
	@FindBy(xpath = "//a[.='Details']")
	private List<WebElement> detailsLinkList;
	
	@FindBy(xpath = "//h5")
	private List<WebElement> priceList;
	
	public PackageListPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public PackageDetailsPage searchPackageAndClick(String packageName, String price)
	{
		for(int i=0;i<packageNameList.size();i++)
		{
			WebDriverUtility.scrollAction(packageNameList.get(i), driver);
		//	WebDriverUtility.waitForElementToBeVisible(packageNameList.get(i), driver);
			if((packageNameList.get(i).getText()).contains(packageName) && (priceList.get(i).getText()).contains(price))
			{
				detailsLinkList.get(i).click();
				break;
			}
		}
		return new PackageDetailsPage(driver);
	}
}
