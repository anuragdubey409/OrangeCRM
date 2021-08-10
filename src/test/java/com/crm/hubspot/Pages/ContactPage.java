package com.crm.hubspot.Pages;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.crm.constant.CRMConstanst;
import com.crm.hubspot.DriverUtils.DriverHelper;
import com.crm.hubspot.GlobalUtils.PropertyFileUtils;

public class ContactPage extends DriverHelper{
	
	
	public ContactPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css="h2[class*='page-head-title']>span")
	private WebElement contactPageTitle;
	
	@FindBy(css="a[class*='add-subscriber']")
	private WebElement createNewContactButton;
	
	@FindBy(className = "modal-title")
	private WebElement newContactFormTitle;
	
	@FindBy(xpath =  "//div[@class='modal-body']/div[@class='form-group']")
	private List<WebElement> newContactFormSize;
	
	@FindBy(css = "select[name='ab-temp-6']")
	private WebElement EmailDropDowm;
	
	@FindBy(css= "select[placeholder='Country']")
	private WebElement countryDropdown;
	
	@FindBy(css= "button[class='btn btn-primary save']")
	private WebElement saveContactButton;
	
	@FindBy(css= "div[data-type='SUBSCRIBER']")
	private WebElement importButton;
	
	@FindBy(css= "input[type='file']")
	private WebElement fileUpload;
	
	public void verifyContactPage(String contactPageText) {
		String getContactPageText = super.getText(contactPageTitle);
		if(StringUtils.isNotEmpty(getContactPageText)) {
			Assert.assertEquals(contactPageText, getContactPageText);
		}
	}
	
	/**
	 * Click On Create New Button
	 */
	public void clickOnCreateNewConactButton() {
		wait.waitForElementToClickable(createNewContactButton);
		super.clickOn(createNewContactButton);
	}

	//Verify NewContact Form Window
	public void verifyNewContactForm() {
		wait.waitForElementToBeVisible(newContactFormTitle);
		String newcontactForm = super.getText(newContactFormTitle);
		Assert.assertTrue(StringUtils.containsIgnoreCase(newcontactForm,CRMConstanst.NewContact));
	}
	
	/**
	 * Create New Contact Button
	 * @param contactDetails
	 */
	public void createNewContact(Map<String,String> contactDetails) {
		this.clickOnCreateNewConactButton();
		this.verifyNewContactForm();
		int newContactFormLength = newContactFormSize.size();
		
		for(int i=1;i<newContactFormLength;i++) {
			String newContactFormTextBox = "//div[@class='modal-body']/div[@class='form-group']["+i+"]//input";
			String getCurrentTextBoxAttribute = super.getAttribute(newContactFormTextBox, "placeholder");
			
			contactDetails.forEach((key,value)->{
				if(getCurrentTextBoxAttribute.equalsIgnoreCase(key)) {
					super.sendKey(newContactFormTextBox, value);
				}else if(key.equalsIgnoreCase("Email")) {
					super.SelectBy(EmailDropDowm, value);	
				}else if(key.equalsIgnoreCase("Country")) {
					super.SelectBy(countryDropdown, value);
				}
			});		
		}
		
		super.clickOn(saveContactButton);
	}
	
	public void clickOnImport() {
		super.clickOn(importButton);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.getWindowHandle();
		String path = PropertyFileUtils.currentProjectPath()+"//src//test//resources//ImportContact.csv";
		super.clickOn(fileUpload);
		//super.sendKey(fileUpload,path);
	}
	
}
