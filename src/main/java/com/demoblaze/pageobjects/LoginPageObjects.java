package com.demoblaze.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	@FindBy(id = "login2")
    public WebElement login_Option_StatusBar_ID;

    @FindBy(id = "loginusername")
    public WebElement login_Username_ID;
    
    @FindBy(id = "loginpassword")
    public WebElement login_Password_ID;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    public WebElement login_Button_XPATH;
    
    @FindBy(id = "nameofuser")
    public WebElement loggedin_Username;
    
    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Close']")
    public WebElement Close_Button_1;
    
    @FindBy(xpath = "//*[@id='logInModal']//button[@class='close']")
    public WebElement Close_Button_2;
    
    @FindBy(xpath = "//*[@class='modal fade' and @id='logInModal']")
    public WebElement login_Modal_Page;
    
}
