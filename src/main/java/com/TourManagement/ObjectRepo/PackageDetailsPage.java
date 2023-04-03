package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.WebDriverUtility;

public class PackageDetailsPage {
	WebDriver driver;
	
	@FindBy(id = "datepicker")
	private WebElement fromDate;
	
	@FindBy(id = "datepicker1")
	private WebElement toDate;
	
	@FindBy(name = "comment")
	private WebElement commentBox;
	
	@FindBy(name = "submit2")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement successMsg;
	
	public PackageDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String bookPackage(String from, String to,String comment)
	{
		fromDate.sendKeys(from);
		toDate.sendKeys(to);
		WebDriverUtility.scrollAction(commentBox, driver);
		commentBox.sendKeys(comment);
		WebDriverUtility.scrollAction(submit, driver);
		submit.click();
		return successMsg.getText();
	}
}
