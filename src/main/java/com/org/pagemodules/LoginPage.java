package com.org.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.beforecomponents.BrowserActions;

public class LoginPage extends BrowserActions {
	
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElement userName;
	

	@FindBy(xpath = "//input[@name='pass']")
	public WebElement password;
	

	@FindBy(xpath = "//button[@name='login']")
	public WebElement loginButton;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	public void sendUserName(String username) {
//		userName.sendKeys(username);
//	}
//	
//	public void sendPassword(String pass) {
//		
//		password.sendKeys(pass);
//		
//	}
//	
	
	public void clickLoginButton() {
		loginButton.click();
		
	}

}
