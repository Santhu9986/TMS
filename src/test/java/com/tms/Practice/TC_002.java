package com.tms.Practice;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;

public class TC_002 extends BaseClass {
	@Test(groups = "regression")
	public void TS_3()
	{
	
		System.out.println("----TS 03---");
		fail();
	}

	@Test(groups = "smoke")
	public void TS_4()
	{
	
		System.out.println("----TS 04---");
	}

}
