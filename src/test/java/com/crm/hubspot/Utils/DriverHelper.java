package com.crm.hubspot.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverHelper {
	
	protected WebDriver driver;
	
	protected DriverHelper(WebDriver driver){
		this.driver = driver;
	}
	
	
	public By getWebElement(String webElement) {
		By element = null;	
		if(webElement.startsWith("//")) {
			element =  By.xpath(webElement);
		}else if(webElement.startsWith("css=")) {
			String ele = webElement.replace("css=", "");
			element=  By.cssSelector(ele);
		}
		return element;
	}
	
	
	public void sendKey(String Webelement,String keysToSend) {
	
		
		
	}
	
	public void sendKey(WebElement element,String keysToSend) {
		try {
			element.sendKeys(keysToSend);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public void clickOn(WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 

}
