package com.tms.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;
import com.TourManagement.GenericLibrary.ExcelUtility;
import com.TourManagement.GenericLibrary.FileUtility;
import com.TourManagement.ObjectRepo.AdminDashboard;
import com.TourManagement.ObjectRepo.AdminSignInPage;
import com.TourManagement.ObjectRepo.ManageBookingsPage;
import com.TourManagement.ObjectRepo.MyTourHistoryPage;
import com.TourManagement.ObjectRepo.PackageDetailsPage;
import com.TourManagement.ObjectRepo.PackageListPage;
import com.TourManagement.ObjectRepo.TmsHomepage;
import com.TourManagement.ObjectRepo.UserHomePage;
import com.TourManagement.ObjectRepo.UserSignInPage;
@Listeners(com.TourManagement.GenericLibrary.ITransform.class)
public class Test002 extends BaseClass {

	String URL = FileUtility.getPropertyValue("url");
	String USERNAME = FileUtility.getPropertyValue("User_name");
	String PASSWORD = FileUtility.getPropertyValue("User_pwd");
	String AdminName = FileUtility.getPropertyValue("Admin_name");
	String AdminPassword = FileUtility.getPropertyValue("Admin_pwd");
	
	@Test
	public void bookTour()
	{
		try
		{
			TmsHomepage homePage = new TmsHomepage(driver); 
			UserSignInPage userSignIn = homePage.clickOnSignIn();
			UserHomePage userHomePage = userSignIn.login(USERNAME, PASSWORD);
			PackageListPage packageList = userHomePage.clickOnTourPackages();
	
			String packageName = ExcelUtility.getDataFromExcel("BookPackage", 1, 0);
			String price = ExcelUtility.getDataFromExcel("BookPackage", 1, 1);
			String fromDate = ExcelUtility.getDataFromExcel("BookPackage", 1, 2);
			String toDate = ExcelUtility.getDataFromExcel("BookPackage", 1, 3);
			String comment = ExcelUtility.getDataFromExcel("BookPackage", 1, 4);
		
			PackageDetailsPage bookTourPackage = packageList.searchPackageAndClick(packageName,price);
			String message = bookTourPackage.bookPackage(fromDate, toDate, comment);
			userHomePage.logout();
			System.out.println(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false)
	public void confirmBooking()
	{
		try
		{
			TmsHomepage homePage = new TmsHomepage(driver);
			AdminSignInPage adminSignIn = homePage.clickOnAdminLogin();
			AdminDashboard adminHomePage = adminSignIn.login(AdminName, AdminPassword);
			ManageBookingsPage manageBooking = adminHomePage.clickOnManageBooking();
	
			String packageName = ExcelUtility.getDataFromExcel("BookPackage", 1, 0);
			String comment = ExcelUtility.getDataFromExcel("BookPackage", 1, 4);
			String expectedResult = ExcelUtility.getDataFromExcel("BookPackage", 1, 5);
			
			manageBooking.confirmBooking(USERNAME, packageName, comment);
	
			homePage = adminHomePage.logout();
		
			UserSignInPage userSignIn = homePage.clickOnSignIn();
			UserHomePage userHomePage = userSignIn.login(USERNAME, PASSWORD);
			MyTourHistoryPage tourHistory = userHomePage.clickOnMyTourHistory();
			String actualResult = tourHistory.statusOfBooking(packageName, comment);
			System.out.println(actualResult);
		
			assertEquals(actualResult, expectedResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void cancelBooking()
	{
		try
		{
			TmsHomepage homePage = new TmsHomepage(driver);
			AdminSignInPage adminSignIn = homePage.clickOnAdminLogin();
			AdminDashboard adminHomePage = adminSignIn.login(AdminName, AdminPassword);
			ManageBookingsPage manageBooking = adminHomePage.clickOnManageBooking();
	
			String packageName = ExcelUtility.getDataFromExcel("BookPackage", 2, 0);
			String comment = ExcelUtility.getDataFromExcel("BookPackage", 2, 4);
			String expectedResult = ExcelUtility.getDataFromExcel("BookPackage", 2, 5);
	
			manageBooking.cancelBooking(USERNAME, packageName, comment);
			
			homePage = adminHomePage.logout();
		
			UserSignInPage userSignIn = homePage.clickOnSignIn();
			UserHomePage userHomePage = userSignIn.login(USERNAME, PASSWORD);
			MyTourHistoryPage tourHistory = userHomePage.clickOnMyTourHistory();
			String Result = tourHistory.statusOfBooking(packageName, comment);
			String[] actualResult = Result.split(" ");
		
			assertEquals(actualResult[0], expectedResult);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
