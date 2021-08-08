package com.crm.hubspot.TestScript;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.constant.CRMConstanst;
import com.crm.hubspot.DriverUtils.TestBase;
import com.crm.hubspot.GlobalUtils.CSVUtils;
import com.crm.hubspot.GlobalUtils.PropertyFileUtils;
import com.crm.hubspot.Pages.ContactPage;
import com.crm.hubspot.Pages.DashboardPage;

public class TestCreateNewContactUsingCSV extends TestBase{
	
	
	String userName;
	String password;	
	String[] header;
	String[] str;
	
	@BeforeClass
	public void init() {
		PropertyFileUtils property = new PropertyFileUtils("testData.properties");
		userName = property.readProperty("AdminUsername");
		password = property.readProperty("AdminPassword");
		String[] header = {"Name","Email","Role","Phone"};
		String[] str = {super.generateRandomName(),"Bestin@gmail.com","IT","Sweper"};
		CSVUtils util = new CSVUtils("ImportContact");
		util.writeCSVFile(header, str);
	}
	
	
	@Test
	public void CreateNewContact() {
		
	
		
		
		//Login to the application
		dashboardPage = loginToTheApplication(userName, password, DashboardPage.class);
		
		//Verify Dashboard
		dashboardPage.verifyDashboard(CRMConstanst.dashboardText);
		
		//Navigate To Contact
		contactPage = dashboardPage.navigateToMenu(CRMConstanst.Contacts, CRMConstanst.Contacts, ContactPage.class);
		
		//veriy Contact Page
		contactPage.verifyContactPage(CRMConstanst.Contacts);

		
   }
	
	
}
