package com.org.beforecomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.org.utility.ExcelReader;


@Listeners(com.org.utility.CustomListner.class)


public class BaseTestComponents {
	
	
	public WebDriver driver;
	ExcelReader dataReader = new ExcelReader();
	String browser = dataReader.getTestData("TestCase4_SignUp", "Browser");
	

	@BeforeMethod
	public void initDriver() {
		
	   if(browser.equals("Chrome")) { 
		   driver = new ChromeDriver();
	   }else {
		   driver = new FirefoxDriver();
	   }
		
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@AfterMethod
	
	public void closeDriver() {
		
		driver.quit();
	}

}
