package com.TourManagement.GenericLibrary;

public class DynamicXpathUtility {
	
	public static String getDynamicXpath(String username, String packageName, String comment, String xPath)
	{
		String dynamicXpath = xPath.replace("%replaceable1", username);
		dynamicXpath = dynamicXpath.replace("%replaceable2", packageName);
		dynamicXpath = dynamicXpath.replace("%replaceable3", comment);
		return dynamicXpath;
	}

	public static String getDynamicXpath(String packageName, String xPath)
	{
		String dynamicXpath = xPath.replace("%replaceble", packageName);
		return dynamicXpath;
	}
	
	public static String getDynamicXpath(String issueType, String desc, String xPath)
	{
		String dynamicXpath = xPath.replace("%replaceable1", issueType);
		dynamicXpath = dynamicXpath.replace("%replaceable2", desc);
		return dynamicXpath;
	}


}
