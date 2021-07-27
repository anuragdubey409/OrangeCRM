package com.crm.hubspot.TestScript;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.hubspot.Pages.DashboardPage;
import com.crm.hubspot.Pages.HomePage;
import com.crm.hubspot.Utils.CRMConstanst;
import com.crm.hubspot.Utils.TestBase;

public class TestLoginToTheApplication extends TestBase{
	String userName;
	String password;	
	
	@BeforeClass
	public void init() {
		userName = property.readProperty("AdminUsername");
		password = property.readProperty("AdminPassword");
	}
	
	@Test
	public void loginToTheApplication() {
		
		//Login to the application
		DashboardPage dashboardPage = super.loginToTheApplication(userName,password,DashboardPage.class);
		
		//verify dashboard Page
		dashboardPage.verifyDashobardPage(CRMConstanst.dashboardText);
		
		dashboardPage.navigateToMenu("Leave", DashboardPage.class);
		
	}

}
