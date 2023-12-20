package com.org.loginfeature;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
		System.out.println();
		loginPm = new LoginPage(driver);
		dataReader = new ExcelReader();
		String userName = dataReader.getTestData("TestCase1_Login", "Username");
		String password = dataReader.getTestData("TestCase1_Login", "Password");
		test.log(Status.PASS, "Send username");
		loginPm.sendKeys(loginPm.userName, userName);
		test.log(Status.PASS, "Send password");
		loginPm.sendKeys(loginPm.password, password);
		test.log(Status.PASS, "Click on logout button");
		loginPm.clickLoginButton();
		
	}
	
}
