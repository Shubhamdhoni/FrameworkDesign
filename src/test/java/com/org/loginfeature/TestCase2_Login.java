package com.org.loginfeature;

import org.testng.annotations.Test;

import com.org.beforecomponents.BaseTestComponents;
import com.org.pagemodules.LoginPage;
import com.org.utility.ExcelReader;

public class TestCase2_Login extends BaseTestComponents{

	LoginPage loginPm;
	ExcelReader dataReader;
	@Test
	public void testCase2() {


		loginPm = new LoginPage(driver);
		dataReader = new ExcelReader();
		
		String userName = dataReader.getTestData("TestCase1_Login", "Username");
		String password = dataReader.getTestData("TestCase1_Login", "Password");
		
		loginPm.sendKeys(loginPm.userName, userName);
		loginPm.sendKeys(loginPm.password, password);
		loginPm.clickLoginButton();
		
		System.out.println("Added 2nd changes");

		System.out.println("changed by shubham");
		

	}

}
