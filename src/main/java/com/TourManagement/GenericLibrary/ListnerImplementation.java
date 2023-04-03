package com.TourManagement.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//execution starts from here
		String name = result.getName();
		test = report.createTest(name);
		Reporter.log(name+"--->Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		test.log(Status.PASS, name+"--->Passed");
		Reporter.log(name+"-->Testscript executed successfully");
	}

	public void onTestFailure(ITestResult result) {
		 String screenShotName = WebDriverUtility.getScreenShot(result.getName(), BaseClass.sdriver);
		 test.addScreenCaptureFromPath(screenShotName);
		 test.log(Status.FAIL, result.getThrowable());			
		 Reporter.log("Testscript execution failed");
	}
	
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test.log(Status.SKIP, name+"-->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript exceution skipped");
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(IPathConstants.ExtentReportPath);
		htmlreport.config().setDocumentTitle("Tour Management System");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("TMS");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_URL", FileUtility.getPropertyValue("url"));
		report.setSystemInfo("Reporter Name", "Santhosh");
	}

	public void onFinish(ITestContext context) {
		
		//consolidate the report
		report.flush();
	}
	

}
