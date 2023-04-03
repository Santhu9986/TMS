package com.tms.Practice;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.TourManagement.GenericLibrary.BaseClass;

public class TC_003 extends BaseClass {
	@Test(groups = "regression")
	public void TS_5()
	{
		System.out.println("----TS 05---");
	}

	@Test(groups = "smoke")
	public void TS_6()
	{
		System.out.println("----TS 06---");
		fail();
	}

}
