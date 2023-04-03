package com.TourManagement.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * This method is used to read the data from excel file.
	 * @param SheetName
	 * @param Rowno
	 * @param ColumnNo
	 * @return String
	 *
	 */
	public static String getDataFromExcel(String SheetName, int Rowno, int ColumnNo) 
	{
		String data="";
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		data = wb.getSheet(SheetName).getRow(Rowno).getCell(ColumnNo).getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * This method is used to get a last row number present in excel sheet
	 * @param SheetName
	 * @return int
	 *
	 */
	public static int getRowCount(String SheetName)
	{
		int LastRow=0;
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		LastRow = wb.getSheet(SheetName).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return LastRow;
	}
	
	/**
	 * This method is used to write a data into a excel sheet.
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param Data
	 */
	public static void setDataToExcel(String SheetName,int RowNo, int ColumnNo,String Data) 
	{
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(SheetName).createRow(RowNo).createCell(ColumnNo).setCellValue(Data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read multiple data from excel sheet
	 * @param SheetName
	 * @return  Object[][]
	 */
	public static Object[][] getDataForDataProvider(String SheetName)
	{
		Object[][] obj = null;
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRow = getRowCount(SheetName);
		Sheet sheet = wb.getSheet(SheetName);
		short lastCell = sheet.getRow(0).getLastCellNum();
		obj= new Object[lastRow+1][lastCell];
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0; j<lastCell;j++)
			{
				String key = sheet.getRow(i).getCell(j).getStringCellValue();
				obj[i][j]=key;
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * This method is used to read multiple data from excel sheet
	 * @param SheetName
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getMultipleData(String SheetName,int column)
	{
		ArrayList<String> array = new ArrayList<String>();
		try {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRow = getRowCount(SheetName);
		Sheet sheet = wb.getSheet(SheetName);
		for(int i=0;i<=lastRow;i++)
		{
				String value = sheet.getRow(i).getCell(column).getStringCellValue();
				array.add(value);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

}
