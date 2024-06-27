package com.demoblaze.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageObjects {
	
	@FindBy(id = "signin2")
	public WebElement signUp_Option;
	
	@FindBy(id = "sign-username")
	public WebElement userName;
	
	@FindBy(id = "sign-password")
	public WebElement passWord;
	
	@FindBy(xpath = "//button[@onclick='register()']")
	public WebElement signUp_Button;

}
