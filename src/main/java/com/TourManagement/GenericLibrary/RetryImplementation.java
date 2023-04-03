package com.TourManagement.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	
	int count=0;
	int maxLimit = 3;

	public boolean retry(ITestResult result) {
			if(count<maxLimit) 
			{
				count++;
				return true;
			}
		return false;
	}
	

}
