package com.TourManagement.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateIssuePage {
	WebDriver driver;
	
	@FindBy(xpath = "//textarea")
	private WebElement Remarktxt;
	
	@FindBy(xpath = "//input")
	private WebElement UpdateBtn;
	
	public UpdateIssuePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void updateIssue(String Remark)
	{
		Remarktxt.sendKeys(Remark);
		UpdateBtn.click();
		driver.close();
	}
	
}
