package com.org.loginfeature;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.org.beforecomponents.BaseTestComponents;
import com.org.pagemodules.CreateNewAccount;

public class TestCase3_SignUp extends BaseTestComponents {

	CreateNewAccount creatAc;

	@Test
	public void testCase3() {

		creatAc = new CreateNewAccount(driver);

		test.log(Status.PASS, "click on creatAccount");
		creatAc.clicks(creatAc.creatAccount);
//1		creatAc.ClickCreatAc();
      
		test.log(Status.PASS, "enter first name");
		creatAc.sendKeys(creatAc.firstName,"shubham");
//1		creatAc.sendFirstName("shubham");

		test.log(Status.PASS, "enter last name");
		creatAc.sendKeys(creatAc.lastName,"dhoni");
//1		creatAc.sendLastName("dhoni");
		
		test.log(Status.PASS, "enter email");
		creatAc.sendKeys(creatAc.emailOrNum, "shubhamdho232@gmail.com");
//1		creatAc.email("shubhamdhoni232@gmail.com");
		
		test.log(Status.PASS, "enter newPassword");
		creatAc.sendKeys(creatAc.newPassword, "2638628");
//1		creatAc.password("23362464");
		
		test.log(Status.PASS, "enter date");
		creatAc.selectbyindex(creatAc.day, 5);
//1		creatAc.sendDate(2);
	
		test.log(Status.PASS,"enter month");
		creatAc.selectbyindex(creatAc.month, 3);
//1		creatAc.sendMonth(10);
		
		test.log(Status.PASS, "enter year");
		creatAc.selectByVisibleText(creatAc.year, "2001");
//1		creatAc.sendYear("2001");

		test.log(Status.PASS, "click on female");
		creatAc.clicks(creatAc.female);
//1		creatAc.female();
		
		test.log(Status.PASS, "click on male");
		creatAc.clicks(creatAc.male);
//1		creatAc.male();
	
		test.log(Status.PASS, "click on signUp");
		creatAc.clicks(creatAc.signUp);
//1		creatAc.signUp();
		
		
	}
}
