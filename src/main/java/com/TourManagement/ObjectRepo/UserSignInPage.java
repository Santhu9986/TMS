package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.BaseClass;

public class UserSignInPage extends BaseClass {
	WebDriver driver;
	
	//creation
	@FindBy(xpath = "//input[@id='email' and @placeholder='Enter your Email']")
	private WebElement emailBox;
	
	@FindBy(id = "password")
	private WebElement passwordBox;
	
	@FindBy(linkText = "Forgot password")
	private WebElement forgotPasswordLink;
	
	@FindBy(name = "signin")
	private WebElement signInBtn;
	
	@FindBy(xpath = "(//a[text()='Facebook'])[2]")
	private WebElement facebookImg;
	
	@FindBy(xpath = "(//a[text()='Google'])[2]")
	private WebElement googleImg;
	
	@FindBy(linkText = "Terms and Conditions")
	private WebElement termsAndConditionLink;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicyLink;
	
	//initialization
	public UserSignInPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Business Library or Logic
	/**
	 * This method is used to login to the User Home Page
	 * @param USERNAME
	 * @param PASSWORD
	 * @return This method return the object type of UserHomePage
	 */
	public UserHomePage login(String USERNAME,String PASSWORD)
	{
		emailBox.sendKeys(USERNAME);
		passwordBox.sendKeys(PASSWORD);
		signInBtn.click();
		return new UserHomePage(driver);
	}
}
