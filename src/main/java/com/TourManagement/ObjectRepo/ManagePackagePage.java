package com.TourManagement.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TourManagement.GenericLibrary.DynamicXpathUtility;
import com.TourManagement.GenericLibrary.ExcelUtility;
import com.TourManagement.GenericLibrary.WebDriverUtility;

public class ManagePackagePage {
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
		
		@FindBy(xpath = "//button[text()='Update']")
		private WebElement updateBtn;
		
		@FindBy(linkText = "Change Image")
		private WebElement changeImageLink;
		
		@FindBy(xpath = "//div[@class='succWrap']")
		private WebElement successMessage;
		
		public ManagePackagePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * This method is used to update package name
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageName(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packageNameBox.clear();
			packageNameBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}

		/**
		 * This method is used to update package Type
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageType(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packageTypeBox.clear();
			packageTypeBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}
		
		/**
		 * This method is used to update package Type
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageLocation(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packageLocationBox.clear();
			packageLocationBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}
		
		/**
		 * This method is used to update package price
		 * @param sheetName
		 * @param string 
		 * @return This method return the type of string.
		 */
		public String updatePackagePrice(String packageName,String sheetName, int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packagePriceBox.clear();
			packagePriceBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}

		/**
		 * This method is used to update package features
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageFeature(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packageFeaturesBox.clear();
			packageFeaturesBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}
		
		/**
		 * This method is used to update package Details
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageDetail(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			packageDetailsBox.clear();
			packageDetailsBox.sendKeys(value);
			WebDriverUtility.scrollAction(updateBtn, driver);
			updateBtn.click();
			return successMessage.getText();
		}
		
		/**
		 * This method is used to update package Type
		 * @param sheetName
		 * @return This method return the type of string.
		 */
		public String updatePackageImage(String packageName,String sheetName,int row, int column)
		{
			clickOnViewDetailsLink(packageName);
			String value = ExcelUtility.getDataFromExcel(sheetName, row, column);
			changeImageLink.click();
			packageImageBox.clear();
			packageImageBox.sendKeys(value);
			//wLib.scrollAction(updateBtn);
			updateBtn.click();
			return successMessage.getText();
		}
		
		private void clickOnViewDetailsLink(String packageName) 
		{
			String xPath = "//span[.='%replaceble']/parent::td/following-sibling::td[.='View Details']";
			String dynamicXpath = DynamicXpathUtility.getDynamicXpath(packageName,xPath);
			WebElement view = driver.findElement(By.xpath(dynamicXpath));
			WebDriverUtility.scrollAction(view, driver);
			view.click();
		}
	}