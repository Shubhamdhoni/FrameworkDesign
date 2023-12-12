package com.org.beforecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BrowserActions extends BaseTestComponents {
	
	
	
	
	
	
	// This all methods are re-usable methods
	
	// sending keys option 
	
	
	public void sendKeys(WebElement element,String value) {
		
		element.sendKeys(value);	
	}
	
	
	public void sendKeys(WebElement element,String value,String message) {
		element.sendKeys(value);
		test.log(Status.PASS, message);
	}
	
	// clicking options 
	public void clicks (WebElement element) {
		element.click();
	}

	// DropDown 
	           //Select by index
	public void selectbyindex(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	           //Select by values
	public void selectbyValues(WebElement element,String Value) {
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}
	
              // Select by VisibleText 	
	public void selectByVisibleText(WebElement element , String Text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	
            // clear text
	public void clearText(WebElement element) {
	    element.clear();
	}
	
            // get text	
	public String getText(WebElement element) {
	    return element.getText();
	}

	
	

	
	
	
	
	
	
	
	
	

	
	
	
}
