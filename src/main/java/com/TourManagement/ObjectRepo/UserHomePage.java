package com.TourManagement.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
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
	
	@FindBy(linkText = "View More Packages")
	private WebElement viewMorePackagesLink;
	
	@FindBy(xpath = "//h4")
	private List<WebElement> packageList;
	
	@FindBy(linkText = "Details")
	private List<WebElement> detailsLink;
	
	@FindBy(linkText = "/ Logout")
	private WebElement logout;
	
	@FindBy(linkText = "My Profile")
	private WebElement myProfile;
	
	@FindBy(linkText = "Change Password")
	private WebElement changePasswodLink;
	
	@FindBy(linkText = "My Tour History")
	private WebElement myTourHistoryLink;
	
	@FindBy(linkText = "Issue Tickets")
	private WebElement issueTicketsLink;
	
	@FindBy(partialLinkText = "Write Us")
	private WebElement writeUsLink;
	
	public UserHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);;
	}
	
	//Business Library / Logic
	/**
	 * This method is used to click on logout button on user home page
	 * @return This method return the object type of TmsHomepage
	 */
	public TmsHomepage logout()
	{
		logout.click();
		return new TmsHomepage(driver);
	}
	
	/**
	 * This method is used to click on tour packages link
	 * @return This method returns the object of type PackageListPage
	 */
	public PackageListPage clickOnTourPackages()
	{
		tourPackageLink.click();
		return new PackageListPage(driver);
		
	}
	
	/**
	 * This method is used to click on write us link in user home page
	 * @return This method return the object type of UserSignInPage
	 */
	public HowCanWeHelpYouPage  clickOnWriteUs()
	{
		writeUsLink.click();
		return new HowCanWeHelpYouPage(driver);
		
	}
	
	/**
	 * This method is used to click on issue ticket link
	 * @return This method return the object type of IssueTicketsPage
	 */
	public IssueTicketsPage clickOnIssueTickets()
	{
		issueTicketsLink.click();
		return new IssueTicketsPage(driver);
	}
	
	/**
	 * This method is used to click on my tour history link
	 * @return This method return the object type of MyTourHistoryPage
	 */
	public MyTourHistoryPage clickOnMyTourHistory()
	{
		myTourHistoryLink.click();
		return new MyTourHistoryPage(driver);
	}
	
}
