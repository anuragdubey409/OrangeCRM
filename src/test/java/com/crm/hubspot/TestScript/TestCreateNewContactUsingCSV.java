package com.crm.hubspot.TestScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.constant.CRMConstanst;
import com.crm.hubspot.DriverUtils.TestBase;
import com.crm.hubspot.GlobalUtils.CSVUtils;
import com.crm.hubspot.GlobalUtils.PropertyFileUtils;
import com.crm.hubspot.Pages.ContactPage;
import com.crm.hubspot.Pages.DashboardPage;
import com.crm.hubspot.beansUtil.ImportContactBean;

public class TestCreateNewContactUsingCSV extends TestBase {

	String userName;
	String password;

	@BeforeClass
	public void init() {
		PropertyFileUtils property = new PropertyFileUtils("testData.properties");
		contactBean = new ImportContactBean();
		userName = property.readProperty("AdminUsername");
		password = property.readProperty("AdminPassword");
		contactBean.setName(super.generateRandomName());
		contactBean.setEmail("Bestin@gmail.com");
		contactBean.setRole("IT");
		contactBean.setPhone("Sweper");
		csvUtils = new CSVUtils("ImportContact");
		String fileParam[] = { contactBean.getName(), contactBean.getEmail(), contactBean.getRole(),
				contactBean.getPhone() };
		contactBean.setName(super.generateRandomName());
		String fileParam1[] = { contactBean.getName(), contactBean.getEmail(), contactBean.getRole(),
				contactBean.getPhone() };
		List<String[]> fileParameter = new ArrayList<String[]>();
		fileParameter.add(fileParam);
		fileParameter.add(fileParam1);
		csvUtils.writeCSVFile(fileParameter);
	}

	@Test
	public void CreateNewContact() {

		// Login to the application
		dashboardPage = loginToTheApplication(userName, password, DashboardPage.class);

		// Verify Dashboard
		dashboardPage.verifyDashboard(CRMConstanst.dashboardText);

		// Navigate To Contact
		contactPage = dashboardPage.navigateToMenu(CRMConstanst.Contacts, CRMConstanst.Contacts, ContactPage.class);

		contactPage.verifyContactPage(CRMConstanst.Contacts);

		contactPage.clickOnImport();
				
	}
	
	@Test
	public void VerifyConactUploadedSuccessfullyUsingEmail() {
		
		
	}

}
