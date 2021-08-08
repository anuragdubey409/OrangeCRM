package com.crm.hubspot.DriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginHelper {
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	

}
