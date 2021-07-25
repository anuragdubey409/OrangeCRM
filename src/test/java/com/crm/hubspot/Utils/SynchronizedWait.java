package com.crm.hubspot.Utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizedWait extends DriverHelper{
	
	 WebDriverWait wait;
	
	protected SynchronizedWait(WebDriver driver) {
		super(driver);
		PropertyFileUtils util = new PropertyFileUtils("testData.properties");
	}

	
	public void waitForElementToBeVisible() {
			
	}
	
	public void waitForElementToClickable() {
		
	}
	
	public void waitForElementToBePresent() {
		
	}

}
