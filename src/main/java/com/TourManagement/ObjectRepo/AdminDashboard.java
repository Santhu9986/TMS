package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.WebDriverUtility;



public class AdminDashboard {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardLink;
	
	@FindBy(partialLinkText =  "Tour Packages")
	private WebElement tourPackagesLink;
	
	@FindBy(linkText = "Create")
	private WebElement createLink;
	
	@FindBy(linkText = "Manage")
	private WebElement manageLink;
	
	@FindBy(linkText = "Manage Users")
	private WebElement manageUsersLink;
	
	@FindBy(linkText = "Manage Booking")
	private WebElement manageBookingLink;
	
	@FindBy(linkText = "Manage Issues")
	private WebElement manageIssuesLink;
	
	@FindBy(linkText = "Manage Enquiries")
	private WebElement manageEnquiriesLink;
	
	@FindBy(linkText = "Manage Pages")
	private WebElement managePagesLink;
	
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement administrator;
	
	@FindBy(xpath = "//a[.=' Logout']")
	private WebElement logout;
	
	public AdminDashboard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to click on Tour Packages
	 */
	public void clickOnTourPackages()
	{
		tourPackagesLink.click();
	}
	
	/**
	 * This method is used to click on create button in tourpackages
	 * @return This method returns the object of type PackageCreationPage
	 */
	public PackageCreationPage clickOnCreateLink()
	{
		createLink.click();
		return new PackageCreationPage(driver);
	}
	
	/**
	 * This method is used to click on manage button in tourpackages
	 * @return This method returns the object of type PackageCreationPage
	 */
	public ManagePackagePage clickOnManageLink()
	{
		manageLink.click();
		return new ManagePackagePage(driver);
	}
	
	/**
	 * This method is used to click on manage booking link
	 * @return This method return the object of type ManageBookingsPage
	 */
	public ManageBookingsPage clickOnManageBooking()
	{
		manageBookingLink.click();
		return new ManageBookingsPage(driver);
	}
	
	/**
	 * This method is used to click on manage issues link in admin page
	 * @return This method return the object type of ManageIssuesPage
	 */
	public ManageIssuesPage clickOnManageIssues()
	{
		manageIssuesLink.click();
		return new ManageIssuesPage(driver);
	}
	
	/**
	 * This method is used to logout from admin and return to homoe page
	 * @return This method return the object type of TmsHomepage
	 */
	public TmsHomepage logout()
	{
		WebDriverUtility.scrollAction(administrator, driver);
		administrator.click();
		logout.click();
		AdminSignInPage signIn = new AdminSignInPage(driver);
		return signIn.clickOnBackToHome();
		
	}
}
