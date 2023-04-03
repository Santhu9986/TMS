package com.TourManagement.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyTourHistoryPage{
	WebDriver driver;
	
	public MyTourHistoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String statusOfBooking(String packageName,String comment)
	{
		String status = driver.findElement(By.xpath("(//a[text()='"+packageName+"']/../following-sibling::td[.='"+comment+"']/following-sibling::td[1])[last()]")).getText();
		return status;
	}

}
