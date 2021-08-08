package com.crm.hubspot.TestScript;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.constant.CRMConstanst;
import com.crm.hubspot.DriverUtils.TestBase;
import com.crm.hubspot.GlobalUtils.PropertyFileUtils;
import com.crm.hubspot.Pages.DashboardPage;
import com.crm.hubspot.Pages.HomePage;

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
		dashboardPage = super.loginToTheApplication(userName,password,DashboardPage.class);
		
		dashboardPage.verifyDashboard(CRMConstanst.dashboardText);
		
		super.logoutFromApplication();
	}
	
	
	
	

}
