package com.tms.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;
import com.TourManagement.GenericLibrary.ExcelUtility;
import com.TourManagement.GenericLibrary.FileUtility;
import com.TourManagement.ObjectRepo.AdminDashboard;
import com.TourManagement.ObjectRepo.AdminSignInPage;
import com.TourManagement.ObjectRepo.ManagePackagePage;
import com.TourManagement.ObjectRepo.PackageCreationPage;
import com.TourManagement.ObjectRepo.TmsHomepage;
@Listeners(com.TourManagement.GenericLibrary.ITransform.class)
public class Test001 extends BaseClass {

		String USERNAME = FileUtility.getPropertyValue("User_name");
		String PASSWORD = FileUtility.getPropertyValue("User_pwd");
		String AdminName = FileUtility.getPropertyValue("Admin_name");
		String AdminPassword = FileUtility.getPropertyValue("Admin_pwd");

		@Test(enabled = false)
		public void createPackageTest()
		{
			try 
			{
				TmsHomepage homePage = new TmsHomepage(driver);
				AdminSignInPage adminLoginPage = homePage.clickOnAdminLogin();
				AdminDashboard adminHomePage = adminLoginPage.login(AdminName, AdminPassword);
				adminHomePage.clickOnTourPackages();
			
				PackageCreationPage createPackage = adminHomePage.clickOnCreateLink();
				String message = createPackage.createPackage("CreatePackage", 1);
				System.out.println(message);
			
				adminHomePage.logout();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void updatePackageTest()
		{
			try
			{
				TmsHomepage homePage = new TmsHomepage(driver);
				AdminSignInPage adminLoginPage = homePage.clickOnAdminLogin();
				AdminDashboard adminHomePage = adminLoginPage.login(AdminName, AdminPassword);
				adminHomePage.clickOnTourPackages();
				ManagePackagePage managePackage = adminHomePage.clickOnManageLink();
			
				String packageName = ExcelUtility.getDataFromExcel("ManagePackage",0,1);
				String message = managePackage.updatePackagePrice(packageName,"ManagePackage",3,1);
				System.out.println(message);
			
				adminHomePage.logout();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

}
