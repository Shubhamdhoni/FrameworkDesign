package com.org.loginfeature;

import org.testng.annotations.Test;

import com.org.beforecomponents.BaseTestComponents;
import com.org.pagemodules.CreateNewAccount;

public class TestCase3_SignUp extends BaseTestComponents {

	CreateNewAccount creatAc;

	@Test
	public void testCase3() {

		creatAc = new CreateNewAccount(driver);

		creatAc.clicks(creatAc.creatAccount);
//1		creatAc.ClickCreatAc();
      
		creatAc.sendKeys(creatAc.firstName,"shubham");
//1		creatAc.sendFirstName("shubham");

		creatAc.sendKeys(creatAc.lastName,"dhoni");
//1		creatAc.sendLastName("dhoni");
		
		creatAc.sendKeys(creatAc.emailOrNum, "shubhamdho232@gmail.com");
//1		creatAc.email("shubhamdhoni232@gmail.com");
		
		creatAc.sendKeys(creatAc.newPassword, "2638628");
//1		creatAc.password("23362464");
		
		creatAc.selectbyindex(creatAc.day, 5);
//1		creatAc.sendDate(2);
	
		creatAc.selectbyindex(creatAc.month, 3);
//1		creatAc.sendMonth(10);
		
		creatAc.selectByVisibleText(creatAc.year, "2001");
//1		creatAc.sendYear("2001");

		creatAc.clicks(creatAc.female);
//1		creatAc.female();
		
		creatAc.clicks(creatAc.male);
//1		creatAc.male();
	
		creatAc.clicks(creatAc.signUp);
//1		creatAc.signUp();
		
		
	}
}
