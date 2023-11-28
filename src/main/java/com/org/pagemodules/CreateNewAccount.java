package com.org.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.org.beforecomponents.BrowserActions;

public class CreateNewAccount extends BrowserActions{

	@FindBy(xpath = "//a[@rel='async']")
	public WebElement creatAccount;

	@FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@name='reg_email__']")
	public WebElement emailOrNum;

	@FindBy(xpath = "//input[@autocomplete='new-password']")
	public WebElement newPassword;

	@FindBy(xpath = "//select[@name='birthday_day']")
	public WebElement day;

	@FindBy(xpath = "//select[@name='birthday_month']")
	public WebElement month;

	@FindBy(xpath = "//select[@name='birthday_year']")
	public WebElement year;

	@FindBy(xpath = "//label[text()='Female']")
	public WebElement female;

	@FindBy(xpath = "//label[text()='Male']")
	public WebElement male;

	@FindBy(xpath = "//label[text()='Custom']")
	public WebElement custom;

	@FindBy(xpath = "//button[@name='websubmit']")
	public WebElement signUp;

	
	public WebDriver driver;

	public CreateNewAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
/*	public void ClickCreatAc() {
		creatAccount.click();
	}

	public void sendFirstName(String firstname) {
		firstName.sendKeys(firstname);
    }
	
	public void sendLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void email(String email) {
		emailOrNum.sendKeys(email);
	}

	public void password(String pasword) {
		newPassword.sendKeys(pasword);
	}
*/
/*	public void sendDate(int date) {
		Select selDate = new Select(day);
		selDate.selectByIndex(date);
	}

	public void sendMonth(int months) {
		Select selMonth = new Select(month);
		selMonth.selectByIndex(months);
	}

	public void sendYear(String years) {
		Select selYear = new Select(year);
		selYear.selectByValue(years);
		}
*/	

/*	public void male() {
		male.click();
	}

	public void female() {
		female.click();
	}

	public void signUp() {
		signUp.click();
	}
*/
}
