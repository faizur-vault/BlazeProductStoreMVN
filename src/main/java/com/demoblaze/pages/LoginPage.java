package com.demoblaze.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.demoblaze.pageobjects.LoginPageObjects;
import com.aventstack.extentreports.ExtentTest;
import com.demoblaze.assertions.Compare;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoginPageObjects {
	WebDriver driver;
	WebDriverWait wait;
	LoginPageObjects pageObjects;
	Logger log;
	ExtentTest extentTestLogger;
	public LoginPage(WebDriver driver, WebDriverWait wait, Logger log, ExtentTest extentTestLogger)
	{
		this.driver=driver;
		this.wait=wait;
		this.log=log;
		this.extentTestLogger=extentTestLogger;
		this.pageObjects=new LoginPageObjects();
		PageFactory.initElements(driver, pageObjects);
	}
		
	public void selectLoginOption() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Option_StatusBar_ID));
		pageObjects.login_Option_StatusBar_ID.click();
		log.info("Clicked Login Option");
		extentTestLogger.info("Clicked Login Option");
	}
	
	public void enterUsername(String uname) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Username_ID));
		pageObjects.login_Username_ID.sendKeys(uname);
		log.info("Entered username");
		extentTestLogger.info("Entered username");
	}
	
	public void enterPassword(String pass) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Password_ID));
		pageObjects.login_Password_ID.sendKeys(pass);
		log.info("Entered Password");
		extentTestLogger.info("Entered Password");
	}
	
	public void clickLoginButton() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Button_XPATH));
		pageObjects.login_Button_XPATH.click();
		log.info("Clicked on Login Button");
		extentTestLogger.info("Clicked on Login Button");
	}
	
	public void verifyLoggedIn() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.loggedin_Username));
		assert(pageObjects.loggedin_Username.isDisplayed());
		log.info("User Loggen In");
		extentTestLogger.info("User Loggen In");
	}
	
	public void verifyWrongPasswordAlert() throws IOException
	{
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(Compare.verifyWrongPasswordAlertText(driver));
		driver.switchTo().alert().accept();;
		log.info("Wrong password alert popped up");
		extentTestLogger.info("Wrong password alert popped up");
	}
	
	public void verifyInvalidUserAlert() throws IOException
	{
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(Compare.verifyInvalidUsernameAlertText(driver));
		driver.switchTo().alert().accept();
		log.info("User does not exist alert popped up");
		extentTestLogger.info("User does not exist alert popped up");
	}
	
	public void clickFooterCloseButton() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.Close_Button_1));
		pageObjects.Close_Button_1.click();
		log.info("Clicked on \"Close\" button");
		extentTestLogger.info("Clicked on \"Close\" button");
	}
	
	public void clickHeaderCloseButton() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.Close_Button_2));
		pageObjects.Close_Button_2.click();
		log.info("Clicked on \"X\" button");
		extentTestLogger.info("Clicked on \"X\" button");
	}
	
	public void verifyLoginModalClosed() throws IOException, InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Option_StatusBar_ID));
		Thread.sleep(2000);  
		assertFalse(pageObjects.login_Modal_Page.isDisplayed());
		log.info("Login Modal view is closed");
		extentTestLogger.info("Login Modal view is closed");
	}

}
