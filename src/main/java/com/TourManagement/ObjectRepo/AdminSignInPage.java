package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSignInPage {
	WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement usernameBox;
	
	@FindBy(name = "password")
	private WebElement passwordBox;
	
	@FindBy(name = "login")
	private WebElement loginBtn;
	
	@FindBy(linkText = "Back to home")
	private WebElement backToHomeBtn;
	
	public AdminSignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to login to the admin page 
	 * @param AdminName
	 * @param AdminPassword
	 * @return This method return the object type of AdminDashboard
	 */
	public AdminDashboard login(String AdminName, String AdminPassword)
	{
		usernameBox.sendKeys(AdminName);
		passwordBox.sendKeys(AdminPassword);
		loginBtn.click();
		return new AdminDashboard(driver);
	}
	
	/**
	 * This method is used to login to the admin page 
	 * @return This method return the object type of UserSignInPage
	 */
	public TmsHomepage clickOnBackToHome()
	{
		backToHomeBtn.click();
		return new TmsHomepage(driver);
	}
}
