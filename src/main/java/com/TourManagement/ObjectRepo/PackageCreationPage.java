package com.TourManagement.ObjectRepo;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TourManagement.GenericLibrary.ExcelUtility;
import com.TourManagement.GenericLibrary.WebDriverUtility;

public class PackageCreationPage {
	WebDriver driver;
	
	@FindBy(id = "packagename")
	private WebElement packageNameBox;
	
	@FindBy(id = "packagetype")
	private WebElement packageTypeBox;
	
	@FindBy(id = "packagelocation")
	private WebElement packageLocationBox;
	
	@FindBy(id = "packageprice")
	private WebElement packagePriceBox;
	
	@FindBy(id = "packagefeatures")
	private WebElement packageFeaturesBox;
	
	@FindBy(id = "packagedetails")
	private WebElement packageDetailsBox;
	
	@FindBy(id = "packageimage")
	private WebElement packageImageBox;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//button[text()='Reset']")
	private WebElement resetBtn;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement successMessage;
	
	public PackageCreationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to create a package
	 * @param sheetName
	 * @param column
	 * @return This method return the type of string.
	 */
	public String createPackage(String sheetName,int column)
	{
		ArrayList<String> packageDetails = ExcelUtility.getMultipleData(sheetName, column);
		packageNameBox.sendKeys(packageDetails.get(0));
		packageTypeBox.sendKeys(packageDetails.get(1));
		packageLocationBox.sendKeys(packageDetails.get(2));
		packagePriceBox.sendKeys(packageDetails.get(3));
		packageFeaturesBox.sendKeys(packageDetails.get(4));
		packageDetailsBox.sendKeys(packageDetails.get(5));
		WebDriverUtility.scrollAction(packageImageBox, driver);
		packageImageBox.sendKeys(packageDetails.get(6));
		createBtn.click();
		return successMessage.getText();
	}

}
