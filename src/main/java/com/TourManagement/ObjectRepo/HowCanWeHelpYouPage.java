package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.WebDriverUtility;


public class HowCanWeHelpYouPage {
	WebDriver driver;
	
	@FindBy(id = "country")
	private WebElement issueDD;
	
	@FindBy(name = "description")
	private WebElement descriptionBox;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public HowCanWeHelpYouPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to create a issue
	 * @param text
	 * @param desc
	 * @return This method return the object type of UserHomePage
	 */
	public ConfirmationPage createIssue(String text, String desc)
	{
		WebDriverUtility.select(text, issueDD);
		descriptionBox.sendKeys(desc);
		submitBtn.click();
		return new ConfirmationPage(driver);
	}

}
