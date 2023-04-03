package com.TourManagement.GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used to get a random number.
	 * @return
	 */
	public static int randomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt();
		return ran;
	}
	
	/**
	 * This method is used to fetch the system date in the format of DD-MM-YYYY HH-MM-SS.
	 * @return
	 */
	public static String formatSystemDate()
	{
		Date dt=new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = dateformat.format(dt);
		return date;
	}

}
