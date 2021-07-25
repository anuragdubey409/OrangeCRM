package com.crm.hubspot.TestScript;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.hubspot.Pages.HomePage;
import com.crm.hubspot.Utils.TestBase;

public class loginToTheApplication extends TestBase{
	String userName;
	String password;	
	
	@BeforeClass
	public void init() {
		userName = property.readProperty("Username");
		password = property.readProperty("Password");
	}
	
	@Test
	public void loginToTheApplication() {
		//Login to the application
		HomePage homePage = super.loginToTheApplication(userName,password,HomePage.class);
		
		
		
	}

}
