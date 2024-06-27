package com.demoblaze.datagenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.demoblaze.base.DriverInstance;
import com.demoblaze.utilities.Utility;

public class DataGenerator extends DriverInstance{
	
	@DataProvider(name="TestData_Login")
	public static Object[][] testDataGenerator(Method met) throws IOException
	{
		FileInputStream excelFile1 = new FileInputStream("./TestData/TestData_BlazeProductStore.xlsx");
		XSSFWorkbook testDataWorkbook1 = new XSSFWorkbook(excelFile1);
		XSSFSheet loginCredsSheet = testDataWorkbook1.getSheet("LoginCredentials");
		int numberOfRows_login = loginCredsSheet.getPhysicalNumberOfRows();
		Object [][] logintestDataArray = new Object[numberOfRows_login-1][2];
		for(int i=1; i<numberOfRows_login; i++)
		{
			XSSFRow dataRow = loginCredsSheet.getRow(i);
			XSSFCell userName = dataRow.getCell(0);
			XSSFCell passWord = dataRow.getCell(1);
			logintestDataArray[i-1][0] = userName.getStringCellValue();
			logintestDataArray[i-1][1] = passWord.getStringCellValue();
		}
		Object [][] testLoginCreds = new Object[1][2];
		switch (met.getName())
		{
		case "TC_DB_Login_001":
			Utility.copySelectedRow(logintestDataArray, testLoginCreds, 0);
			break;
			
		case "TC_DB_Login_002":
			Utility.copySelectedRow(logintestDataArray, testLoginCreds, 1);
			break;
			
		case "TC_DB_Login_003":
			Utility.copySelectedRow(logintestDataArray, testLoginCreds, 2);
			break;
		
		default:
			log.info("No test case selected");
			break;	
		}
		
		testDataWorkbook1.close();
		return testLoginCreds;
	}
}
