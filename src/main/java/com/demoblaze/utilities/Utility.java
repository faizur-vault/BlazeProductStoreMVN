package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	public static Object fetchPropertyValue(String key) throws IOException
	{
		FileInputStream propertyFile = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(propertyFile);
		return property.get(key);
	}
	
	public static String fetchElementLocatorValue(String key) throws IOException
	{
		FileInputStream propertyFile = new FileInputStream("./Config/Elements.properties");
		Properties property = new Properties();
		property.load(propertyFile);
		return property.get(key).toString();
	}
	
	public static void copySelectedRow(Object[][] sourceArray, Object[][] destinationArray, int rowNum)
	{
		if(sourceArray[rowNum].length > 0)
		{
			for(int i=0; i<sourceArray[rowNum].length; i++)
			{
				destinationArray[0][i] = sourceArray[rowNum][i];
			}
		}
		else
		{
			System.out.println("Arrays are empty or has different lengths");
		}
	}

}
