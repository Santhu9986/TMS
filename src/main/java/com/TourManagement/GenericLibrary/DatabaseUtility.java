package com.TourManagement.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {
	static Connection con=null;
	
	/**
	 * This method is used to get connection to Database.
	 */
	public static void connectToDB() 
	{
		try {
			con=DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * This method is used to execute a query in database and return a result.
	 * @param query
	 * @param columnIndex
	 * @param expData
	 */
	public static void executeQueryAndGetData(String query,int columnIndex,String expData )
	{
		try {
		ResultSet res = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(res.next())
		{
			String data = res.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				System.out.println(expData+" is Verified");
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println(expData+" is not Verified");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to close the database
	 */
	public static void closeDB() 	
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
