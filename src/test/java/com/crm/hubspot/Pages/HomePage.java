package com.crm.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.hubspot.Utils.DriverHelper;

public class HomePage extends DriverHelper{

	 HomePage(WebDriver driver) {
			super(driver);
		}
	
	



	@FindBy(css = "")
	private WebElement homePage;

	
	
	public void verifyHomePage() {
		clickOn(homePage);
		
		sendKey(homePage, "anc");
	}

}
