package com.org.beforecomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.org.utility.ExcelReader;
import com.org.utility.ExtentReportNG;

@Listeners(com.org.utility.CustomListner.class)

public class BaseTestComponents {

	public WebDriver driver;
	ExcelReader dataReader = new ExcelReader();
	String browser = dataReader.getTestData("TestCase4_SignUp", "Browser");
	public ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();

////	
////	@BeforeSuite
//	public void generateReport() {
//		test = extent.createTest(this.getClass().getSimpleName());
//		
//	}
//	
//	
//	// Method for adding logs passed from test cases
//	public void reportLog(String message) {
//		
//		test.log(Status.PASS, message);// For extentTest HTML report
////		logger.info("Message: " + message);
////		Reporter.log(message);
//
//	}
	
	
	@BeforeMethod
	public void initDriver() {
		
		test = extent.createTest(this.getClass().getSimpleName());

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else {
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

	@AfterSuite
	public void closeExtent() {
		
		extent.flush();
	}
}
