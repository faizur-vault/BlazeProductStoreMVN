package com.demoblaze.testcases.login;

import java.io.IOException;

import com.demoblaze.datagenerator.DataGenerator;
import com.demoblaze.pages.LoginPage;
import org.testng.annotations.Test;
import com.demoblaze.base.DriverInstance;

public class TS_DB_001_Login extends DriverInstance
{
	@Test(dataProvider = "TestData_Login", dataProviderClass = DataGenerator.class)
	public void TC_DB_Login_001(String uname, String pwd) throws IOException
	{
		extentTestLogger = extentReports.createTest("TC_DB_Login_001");
		LoginPage login = new LoginPage(driver, wait, log, extentTestLogger);
		login.selectLoginOption();
		login.enterUsername(uname);
		login.enterPassword(pwd);
		login.clickLoginButton();
		login.verifyLoggedIn();
		log.info("Valid Login test passed");
	}
	
	@Test(dataProvider = "TestData_Login", dataProviderClass = DataGenerator.class)
	public void TC_DB_Login_002(String uname, String pwd) throws IOException
	{
		extentTestLogger = extentReports.createTest("TC_DB_Login_002");
		LoginPage login = new LoginPage(driver, wait, log, extentTestLogger);
		login.selectLoginOption();
		login.enterUsername(uname);
		login.enterPassword(pwd);
		login.clickLoginButton();
		login.verifyWrongPasswordAlert();
		log.info("Invalid password login test passed");
	}
	
	@Test(dataProvider = "TestData_Login", dataProviderClass = DataGenerator.class)
	public void TC_DB_Login_003(String uname, String pwd) throws IOException
	{
		extentTestLogger = extentReports.createTest("TC_DB_Login_003");
		LoginPage login = new LoginPage(driver, wait, log, extentTestLogger);
		login.selectLoginOption();
		login.enterUsername(uname);
		login.enterPassword(pwd);
		login.clickLoginButton();
		login.verifyInvalidUserAlert();
		log.info("Invalid user login test passed");
	}

}
