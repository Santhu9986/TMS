package com.tms.Practice;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;

public class TC_001 extends BaseClass {
	
	
	@Test(groups = "regression")
	public void TS_1()
	{
		System.out.println("----TS 01---");
	}

	@Test(groups = "smoke")
	public void TS_2()
	{
		System.out.println("----TS 02---");
		fail();
	}

}
