package com.TourManagement.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.DynamicXpathUtility;
import com.TourManagement.GenericLibrary.WebDriverUtility;


public class ManageIssuesPage {
	WebDriver driver;
	
	public ManageIssuesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void manageIssue(String USERNAME,String text, String desc,String Remark)
	{
		WebElement view = getViewLink(USERNAME, text, desc);
		WebDriverUtility.scrollAction(view, driver);
		view.click();
		WebDriverUtility.switchToWindow("Update Compliant", driver);
		UpdateIssuePage uip = new UpdateIssuePage(driver);
		uip.updateIssue(Remark);
		WebDriverUtility.switchToWindow("manage Issues", driver);
		
	}
	
	public WebElement getViewLink(String USERNAME,String text, String desc)
	{
		String xPath = "(//span[.='%replaceable1']/../following-sibling::td/span[.='%replaceable2']/../following-sibling::td/span[.='%replaceable3']/../following::a[.='View '])[last()]";
		String dynamicXpath = DynamicXpathUtility.getDynamicXpath(USERNAME, text, desc, xPath);
		return driver.findElement(By.xpath(dynamicXpath));
	}
}
