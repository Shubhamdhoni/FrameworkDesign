package com.org.beforecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserActions {
	
	// This all methods are re-usable methods
	
	// sending keys option 
	public void sendKeys(WebElement element,String value) {
		element.sendKeys(value);	
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
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
