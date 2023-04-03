package com.TourManagement.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TmsHomepage {
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeLink;
	
	@FindBy(linkText = "About")
	private WebElement aboutLink;
	
	@FindBy(linkText = "Tour Packages")
	private WebElement tourPackageLink;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicyLink;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUseLink;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsLink;
	
	@FindBy(linkText = " Enquiry ")
	private WebElement enquiryLink;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signUpLink;
	
	@FindBy(partialLinkText = "Sign In")
	private WebElement signInLink;
	
	@FindBy(linkText = "Admin Login")
	private WebElement adminLoginLink;
	
	@FindBy(linkText = "View More Packages")
	private WebElement viewMorePackagesLink;
	
	@FindBy(xpath = "//h4")
	private List<WebElement> pkgList;
	
	@FindBy(linkText = "Details")
	private List<WebElement> detailsLink;
	
	public TmsHomepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);;
	}

	//Business Library or Logic
	
	/**
	 * This method is used to click on sign in button 
	 * @return This method return the object type of UserSignInPage
	 */
	public UserSignInPage clickOnSignIn()
	{
		signInLink.click();
		return new UserSignInPage(driver);
	}
	
	/**
	 * This method is used to click on Admin sign in button 
	 * @return This method return the object type of AdminSignInPage
	 */
	public AdminSignInPage clickOnAdminLogin()
	{
		adminLoginLink.click();
		return new AdminSignInPage(driver);
	}
	
}
