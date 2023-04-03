package com.TourManagement.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.DynamicXpathUtility;

public class IssueTicketsPage {
	WebDriver driver;
	
	public IssueTicketsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to check the status of issues raised
	 * @param issueType
	 * @param description
	 * @return this method return the type of string 
	 */
	public String getIssueStatus(String issueType,String description)
	{
		WebElement issue = getIssue(issueType, description);
		return issue.getText();
	}
	
	public WebElement getIssue(String issueType, String desc)
	{
		String xPath = "(//td[.='%replaceable1']/following-sibling::td[.='%replaceable2']/following-sibling::td[1])[last()]";
		String dynamicXpath = DynamicXpathUtility.getDynamicXpath(issueType, desc, xPath);
		return driver.findElement(By.xpath(dynamicXpath));
	}

}
