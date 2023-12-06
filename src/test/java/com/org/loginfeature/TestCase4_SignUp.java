package com.org.loginfeature;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.org.beforecomponents.BaseTestComponents;
import com.org.pagemodules.CreateNewAccount;
import com.org.utility.ExcelReader;

public class TestCase4_SignUp extends BaseTestComponents {

	CreateNewAccount creatAc;
	ExcelReader dataReader;

	@Test
	public void testCase4() {
		creatAc = new CreateNewAccount(driver);
		dataReader = new ExcelReader();

/*	1  	creatAc.ClickCreatAc();
		creatAc.sendFirstName("praveen");
		creatAc.sendLastName("hudgi");
		creatAc.email("praveenh242@gmail.com");
		creatAc.sendDate(5);
		creatAc.sendMonth(11);
		creatAc.sendYear("2005");
		creatAc.female();
		creatAc.male();
		creatAc.signUp();
  */
/*2		creatAc.clicks(creatAc.creatAccount);
		creatAc.sendKeys(creatAc.firstName, "praveen");
		creatAc.sendKeys(creatAc.lastName, "hudgi");
		creatAc.sendKeys(creatAc.emailOrNum, "praveenhu425@gmail.com");
		creatAc.sendKeys(creatAc.newPassword, "12345678");
		creatAc.selectbyindex(creatAc.day, 3);
		creatAc.selectbyindex(creatAc.month, 8);
		creatAc.selectByVisibleText(creatAc.year, "2005");
		creatAc.clicks(creatAc.female);
		creatAc.clicks(creatAc.male);
		creatAc.clicks(creatAc.signUp);
*/	
	// data from excel direct	
		
		
		String firstName = dataReader.getTestData("TestCase4_SignUp", "firstName");
		String lastName = dataReader.getTestData("TestCase4_SignUp", "lastName");
		String emailOrNum = dataReader.getTestData("TestCase4_SignUp", "email");
		String newPassword = dataReader.getTestData("TestCase4_SignUp", "newPassword");
		String day = dataReader.getTestData("TestCase4_SignUp", "day");
		String month = dataReader.getTestData("TestCase4_SignUp", "month");
		String year = dataReader.getTestData("TestCase4_SignUp", "year");
		String male = dataReader.getTestData("TestCase4_SignUp", "gender");
		
		test.log(Status.PASS, "click on creatAccount");
		creatAc.clicks(creatAc.creatAccount);
		
		test.log(Status.PASS, "enter first name");
		creatAc.sendKeys(creatAc.firstName, firstName);
		
		test.log(Status.PASS, "enter last name");
		creatAc.sendKeys(creatAc.lastName, lastName);
		
		test.log(Status.PASS, "enter email");
		creatAc.sendKeys(creatAc.emailOrNum, emailOrNum);
		
		test.log(Status.PASS, "enter newPassword");
		creatAc.sendKeys(creatAc.newPassword, newPassword);
		
		test.log(Status.PASS, "enter date");
		creatAc.selectbyValues(creatAc.day,day);
		
		test.log(Status.PASS,"enter month");
		creatAc.selectbyValues(creatAc.month, month);
		
		test.log(Status.PASS, "enter year");
		creatAc.selectByVisibleText(creatAc.year, year);
	
		
		if(male.equals("male")) {
			test.log(Status.PASS, "click on male");
			creatAc.clicks(creatAc.male);
		}else {
			test.log(Status.PASS, "click on female");
			creatAc.clicks(creatAc.female);
		}
		
	}

}
