package com.demoblaze.pages;

import java.io.IOException;

import com.demoblaze.pageobjects.SignUpPageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	WebDriver driver;
	WebDriverWait wait;
	SignUpPageObjects pageObjects;
	
	public SignUpPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		this.pageObjects=new SignUpPageObjects();
		PageFactory.initElements(driver, pageObjects);
	}
	
	public void selectSignUpOption() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.signUp_Option));
		pageObjects.signUp_Option.click();
	}
	
	public void enterUsername(String uname) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.userName));
		pageObjects.userName.sendKeys(uname);
	}
	
	public void enterPassword(String pass) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.passWord));
		pageObjects.passWord.sendKeys(pass);
	}
	
	public void clickSignUpButton() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.signUp_Button));
		pageObjects.signUp_Button.click();
	}
	
	public void verifyUserCreated() throws IOException
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		assert(alert.getText().equalsIgnoreCase("Sign up successful.") || alert.getText().equalsIgnoreCase("This user already exist."));
        alert.accept();
	}

} 
