package com.tms.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;
import com.TourManagement.GenericLibrary.ExcelUtility;
import com.TourManagement.GenericLibrary.FileUtility;
import com.TourManagement.ObjectRepo.AdminDashboard;
import com.TourManagement.ObjectRepo.AdminSignInPage;
import com.TourManagement.ObjectRepo.ConfirmationPage;
import com.TourManagement.ObjectRepo.HowCanWeHelpYouPage;
import com.TourManagement.ObjectRepo.IssueTicketsPage;
import com.TourManagement.ObjectRepo.ManageIssuesPage;
import com.TourManagement.ObjectRepo.TmsHomepage;
import com.TourManagement.ObjectRepo.UserHomePage;
import com.TourManagement.ObjectRepo.UserSignInPage;

public class Test003 extends BaseClass {

		String URL = FileUtility.getPropertyValue("url");
		String USERNAME = FileUtility.getPropertyValue("User_name");
		String PASSWORD = FileUtility.getPropertyValue("User_pwd");
		String AdminName = FileUtility.getPropertyValue("Admin_name");
		String AdminPassword = FileUtility.getPropertyValue("Admin_pwd");
		
		@Test
		public void createIssueTest()
		{
			try
			{
				TmsHomepage homePage = new TmsHomepage(driver);
				UserSignInPage userSignInPage = homePage.clickOnSignIn();
				UserHomePage userHomePage = userSignInPage.login(USERNAME, PASSWORD);
				HowCanWeHelpYouPage issue = userHomePage.clickOnWriteUs();
				
				String text = ExcelUtility.getDataFromExcel("Create Issue", 1, 0);
				String desc = ExcelUtility.getDataFromExcel("Create Issue", 1, 1);
			
				ConfirmationPage confirmation = issue.createIssue(text, desc);
				userHomePage = confirmation.getConfirmMessage();
				homePage = userHomePage.logout();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void manageIssueTest()
		{
			try
			{
				TmsHomepage homePage = new TmsHomepage(driver);
				AdminSignInPage adminLogin = homePage.clickOnAdminLogin();
				AdminDashboard adminHomePage = adminLogin.login(AdminName, AdminPassword);
				ManageIssuesPage issues = adminHomePage.clickOnManageIssues();
			
				String text = ExcelUtility.getDataFromExcel("Create Issue", 1, 0);
				String desc = ExcelUtility.getDataFromExcel("Create Issue", 1, 1);
				String remark = ExcelUtility.getDataFromExcel("Create Issue", 1, 2);
			
				issues.manageIssue(USERNAME, text, desc,remark);
		
				homePage = adminHomePage.logout();
				UserSignInPage userSignInPage = homePage.clickOnSignIn();
				UserHomePage userHomePage = userSignInPage.login(USERNAME, PASSWORD);
				IssueTicketsPage issueTicket = userHomePage.clickOnIssueTickets();
				String result = issueTicket.getIssueStatus(text, desc);
			
				assertEquals(remark, result);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

}

