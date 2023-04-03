package com.TourManagement.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.DynamicXpathUtility;
import com.TourManagement.GenericLibrary.WebDriverUtility;

public class ManageBookingsPage{
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement successMessage;
	
	public ManageBookingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to confirm the booking 
	 * @param Username
	 * @param PackageName
	 * @param Comment
	 * @return This method return string value of success message
	 */
	public String confirmBooking(String Username,String PackageName,String Comment)
	{
		
		WebElement confirmBtn = getConfirmBtn(Username, PackageName, Comment);
		WebDriverUtility.scrollAction(confirmBtn, driver);
		confirmBtn.click();
		WebDriverUtility.acceptAlert(driver);
		WebDriverUtility.waitForElementToBeVisible(successMessage, driver);
		return successMessage.getText();
	}
	
	/**
	 * This method is used to cancel the booking 
	 * @param Username
	 * @param PackageName
	 * @param Comment
	 * @return This method return string value of success message
	 */
	public String cancelBooking(String Username,String PackageName,String Comment)
	{
		WebElement cancelBtn = getCancelBtn(Username, PackageName, Comment);
		WebDriverUtility.scrollAction(cancelBtn, driver);
		cancelBtn.click();
		WebDriverUtility.acceptAlert(driver);
		WebDriverUtility.waitForElementToBeVisible(successMessage, driver);
		String[] message = successMessage.getText().split(" ");
		return message[0];
		
	}
	
	public WebElement getConfirmBtn(String Username,String PackageName,String Comment)
	{
		String xPath = "(//span[.='%replaceable1']/../following-sibling::td[.='%replaceable2']/following-sibling::td[.='%replaceable3']/following-sibling::td//a[.='Confirm'])[last()]";
		String dynamicXpath = DynamicXpathUtility.getDynamicXpath(Username,PackageName,Comment,xPath);
		return driver.findElement(By.xpath(dynamicXpath));
	}
	
	public WebElement getCancelBtn(String Username,String PackageName,String Comment)
	{
		String xPath = "(//span[.='%replaceable1']/../following-sibling::td[.='%replaceable2']/following-sibling::td[.='%replaceable3']/following-sibling::td//a[.='Cancel'])[last()]";
		String dynamicXpath = DynamicXpathUtility.getDynamicXpath(Username,PackageName,Comment,xPath);
		return driver.findElement(By.xpath(dynamicXpath));		
	}
}
