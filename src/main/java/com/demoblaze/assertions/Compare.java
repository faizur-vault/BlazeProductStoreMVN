package com.demoblaze.assertions;

import org.openqa.selenium.WebDriver;

public class Compare {
	
	public static String WrongPwordAlert = "Wrong password.";
	public static String InvalidUserAlert = "User does not exist.";
	
	public static boolean validatePageURL(WebDriver driver, String expURL)
	{
		boolean bool = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expURL))
		{
			bool=true;
		}
		return bool;
	}
	
	public static boolean validatePageUTitle(WebDriver driver, String expTitle)
	{
		boolean bool = false;
		if(driver.getTitle().equalsIgnoreCase(expTitle))
		{
			bool=true;
		}
		return bool;
	}
	
	public static boolean verifyWrongPasswordAlertText(WebDriver driver)
	{
		boolean bool = false;
		if(driver.switchTo().alert().getText().equalsIgnoreCase(WrongPwordAlert))
		{
			bool=true;
		}
		return bool;
	}
	
	public static boolean verifyInvalidUsernameAlertText(WebDriver driver)
	{
		boolean bool = false;
		if(driver.switchTo().alert().getText().equalsIgnoreCase(InvalidUserAlert))
		{
			bool=true;
		}
		return bool;
	}

}
