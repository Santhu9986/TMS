package com.TourManagement.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	
	/**
	 * This method is used to fetch value from property file.
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public static String getPropertyValue(String key)
	{
		String value="";
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pro = new Properties();
		pro.load(fis);
		value = pro.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
