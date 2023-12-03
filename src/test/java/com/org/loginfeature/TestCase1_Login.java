package com.org.loginfeature;
import org.testng.annotations.Test;
import com.org.beforecomponents.BaseTestComponents;
import com.org.pagemodules.LoginPage;
import com.org.utility.CustomListner;
import com.org.utility.ExcelReader;
import com.org.utility.Retry;

public class TestCase1_Login extends BaseTestComponents {
	
	LoginPage loginPm;
	ExcelReader dataReader;
	
		
	@Test()
	public void testCase1() {
		//retryAnalyzer=Retry.class
		loginPm = new LoginPage(driver);
		dataReader = new ExcelReader();
		String userName = dataReader.getTestData("TestCase1_Login", "Username");
		String password = dataReader.getTestData("TestCase1_Login", "Password");
		//loginPm.sendUserName("hello@gmail.com");
		//reportLog("Sending username");
		loginPm.sendKeys(loginPm.userName, userName);
		//report.reportLog("Sending Password");
		loginPm.sendKeys(loginPm.password, password);
		//report.reportLog("Click on login button");
		loginPm.clickLoginButton();
		
	}
	
}
