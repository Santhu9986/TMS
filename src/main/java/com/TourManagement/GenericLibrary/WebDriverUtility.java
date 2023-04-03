package com.TourManagement.GenericLibrary;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is used to maximize the window
	 * @param driver 
	 * 
	 */
	public static void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait till page gets loaded.
	 * @param driver 
	 */
	public static void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IPathConstants.DURATION));
	}
	
	/**
	 * This method is used to make use of implicit wait.
	 * @param driver 
	 */
	public static void waitForImplicit(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.DURATION));
	}
	
	/**
	 * This method is used to wait until the visibility of element in application.
	 * @param Element
	 * @param driver 
	 */
	public static void waitForElementToBeVisible(WebElement Element, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.DURATION));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	/**
	 * This method is used to wait till the given title present
	 * @param partialTitle
	 * @param driver 
	 */
	public static void waitForTitleContains(String partialTitle, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.DURATION));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	/**
	 * This method is used Select the element in the list by using index of the element.
	 * @param Element
	 * @param index
	 */
	public static void select(WebElement Element, int index)
	{
		Select s = new Select(Element);
		s.selectByIndex(index);
		
	}
	
	/**This method is used Select the element in the list by using value of the element.
	 * This method is used
	 * @param Element
	 * @param value
	 */
	public static void select(WebElement Element, String value)
	{
		Select s = new Select(Element);
		s.selectByValue(value);
		
	}
	
	/**
	 * This method is used Select the element in the list by text visibility of the element.
	 * @param text
	 * @param Element
	 */
	public static void select(String visibleText, WebElement Element)
	{
		Select s = new Select(Element);
		s.selectByVisibleText(visibleText);
		
	}
	
	/**
	 * This method is used to mouse over functionality.
	 * @param element
	 * @param driver 
	 */
	public static void mouseHover(WebElement element, WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	
	/**
	 * This method is used to move a element from source to destination
	 * @param Source
	 * @param Destination
	 * @param driver 
	 */
	public static void dragAndDrop(WebElement Source, WebElement Destination, WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(Source, Destination).perform();
	}
	
	/**
	 * This method is used to double click on the element
	 * @param element
	 * @param driver 
	 */
	public static void doubleClickAction(WebElement element, WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to perform a right click on the element.
	 * @param element
	 * @param driver 
	 */
	public static void rightClick(WebElement element, WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used to switch a frame by using the index value
	 * @param index
	 * @param driver 
	 */
	public static void switchToFrame(int index, WebDriver driver)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch a frame by using the Name or Id of the frame
	 * @param NameorId
	 * @param driver 
	 */
	public static void switchToFrame(String NameorId, WebDriver driver)
	{
		driver.switchTo().frame(NameorId);
	}
	
	/**
	 * This method is used to switch a frame by using element of frame
	 * @param frameElement
	 * @param driver 
	 */
	public static void switchToFrame(WebElement frameElement, WebDriver driver)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method is used to accept the alert
	 * @param driver 
	 */
	public static void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to cancel the alert
	 * @param driver 
	 */
	public static void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to get the text present in the alert
	 * @param driver 
	 */
	public static void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to switch the window by using the title
	 * @param partialTitle
	 * @param driver 
	 */
	public static void switchToWindow(String partialTitle, WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) 
		{
			String currentWinTitle = driver.switchTo().window(win).getTitle();
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to take a screen shot.
	 * @param ScreenShotName
	 * @param driver 
	 * @return 
	 * @throws Throwable
	 */
	public static String getScreenShot(String ScreenShotName, WebDriver driver) 
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(IPathConstants.ScreenShotPath+ScreenShotName+" "+JavaUtility.formatSystemDate()+".png");
		try {
		FileUtils.copyFile(src, dest);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	/**
	 * This method is used to scroll down
	 * @param driver 
	 */
	public static void scrollBarAction(int from, int to, WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo("+from+","+to+")");
	}
	
	/**
	 * This method is used to scroll until the specified element is found
	 * @param Element
	 * @param driver 
	 */
	public static void scrollAction(WebElement Element, WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = Element.getLocation().getY();
		jse.executeScript("window.scrollTo(0,"+y+")");
	}

	
}
