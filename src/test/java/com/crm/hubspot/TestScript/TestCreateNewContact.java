package com.crm.hubspot.TestScript;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.constant.CRMConstanst;
import com.crm.hubspot.DriverUtils.TestBase;
import com.crm.hubspot.GlobalUtils.PropertyFileUtils;
import com.crm.hubspot.Pages.ContactPage;
import com.crm.hubspot.Pages.DashboardPage;

public class TestCreateNewContact extends TestBase{
	
	String userName;
	String password;	
	Map<String, String> newContactDetails;
	
	@BeforeClass
	public void init() {
		PropertyFileUtils property = new PropertyFileUtils("testData.properties");
		userName = property.readProperty("AdminUsername");
		password = property.readProperty("AdminPassword");
		newContactDetails = new HashMap<String, String>();
		newContactDetails.put(CRMConstanst.FirstName, super.generateRandomName());
		newContactDetails.put(CRMConstanst.LastName , CRMConstanst.LastNameValue);
		newContactDetails.put(CRMConstanst.Role, CRMConstanst.RoleValue);
		newContactDetails.put(CRMConstanst.Company,CRMConstanst.CompanyValue);
		newContactDetails.put(CRMConstanst.Tag,CRMConstanst.TagValue);
		newContactDetails.put(CRMConstanst.Address, CRMConstanst.AddressValue);
		newContactDetails.put(CRMConstanst.City,CRMConstanst.CityValue);
		newContactDetails.put(CRMConstanst.State, CRMConstanst.StateValue);
		newContactDetails.put(CRMConstanst.Email, CRMConstanst.EmailValue);
		newContactDetails.put(CRMConstanst.Country , CRMConstanst.CountryValue);
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
		
		//Create New Contact
		contactPage.createNewContact(newContactDetails);
		
		
		super.logoutFromApplication();
	}
	
	

}
