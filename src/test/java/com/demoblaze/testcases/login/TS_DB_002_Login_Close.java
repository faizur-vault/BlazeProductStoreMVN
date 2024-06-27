package com.demoblaze.testcases.login;

import java.io.IOException;

import org.testng.annotations.Test;
import com.demoblaze.base.DriverInstance;
import com.demoblaze.pages.LoginPage;

public class TS_DB_002_Login_Close extends DriverInstance
{
	@Test
	public void TC_DB_Login_Close_004() throws IOException, InterruptedException
	{
		extentTestLogger = extentReports.createTest("TC_DB_Login_Close_004");
		LoginPage login = new LoginPage(driver, wait, log, extentTestLogger);
		login.selectLoginOption();
		login.clickHeaderCloseButton();
		login.verifyLoginModalClosed();
		log.info("CLose Login Module Test case1 passed");
	}
	
	@Test
	public void TC_DB_Login_Close_005() throws IOException, InterruptedException
	{
		extentTestLogger = extentReports.createTest("TC_DB_Login_Close_005");
		LoginPage login = new LoginPage(driver, wait, log, extentTestLogger);
		login.selectLoginOption();
		login.clickFooterCloseButton();
		login.verifyLoginModalClosed();
		log.info("CLose Login Module Test case1 passed");
	}
	
	
} 
