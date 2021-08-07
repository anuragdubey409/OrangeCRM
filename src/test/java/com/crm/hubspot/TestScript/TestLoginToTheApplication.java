package com.crm.hubspot.TestScript;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.hubspot.Pages.DashboardPage;
import com.crm.hubspot.Pages.HomePage;
import com.crm.hubspot.Utils.CRMConstanst;
import com.crm.hubspot.Utils.PropertyFileUtils;
import com.crm.hubspot.Utils.TestBase;

public class TestLoginToTheApplication extends TestBase{
	String userName;
	String password;	
	
	@BeforeClass
	public void init() {
		PropertyFileUtils property = new PropertyFileUtils("testData.properties");
		userName = property.readProperty("AdminUsername");
		password = property.readProperty("AdminPassword");
	}
	
	@Test
	public void loginToTheApplication() {
		
		//Login to the application
		DashboardPage dashboardPage = super.loginToTheApplication(userName,password,DashboardPage.class);
		
		dashboardPage.verifyDashboard(CRMConstanst.dashboardText);
		
		super.logoutFromApplication();
	}
	
	
	
	

}
