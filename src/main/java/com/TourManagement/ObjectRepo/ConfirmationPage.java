package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.WebDriverUtility;

public class ConfirmationPage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='con-top animated wow fadeInUp animated animated']/h4")
	private WebElement confirmationMsg;
	
	
	public ConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public UserHomePage getConfirmMessage()
	{
		WebDriverUtility.waitForElementToBeVisible(confirmationMsg, driver);
		String message = confirmationMsg.getText();
		System.out.println("Issue-->"+message);
		return new UserHomePage(driver);
	}

}
