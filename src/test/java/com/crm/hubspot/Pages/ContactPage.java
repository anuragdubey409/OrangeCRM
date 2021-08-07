package com.crm.hubspot.Pages;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.crm.hubspot.Utils.CRMConstanst;
import com.crm.hubspot.Utils.DriverHelper;

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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.clickOn(createNewContactButton);
	}

	//Verify NewContact Form Window
	public void verifyNewContactForm() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newcontactForm = super.getText(newContactFormTitle);
		Assert.assertTrue(StringUtils.containsIgnoreCase(newcontactForm,CRMConstanst.NewContact));
	}
	
	public void createNewContact(Map<String,String> contactDetails) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.clickOnCreateNewConactButton();
		this.verifyNewContactForm();
		int newContactFormLength = newContactFormSize.size();
		
		for(int i=1;i<newContactFormLength;i++) {
			String newContactFormTextBox = "//div[@class='modal-body']/div[@class='form-group']["+i+"]//input";
			String getCurrentTextBoxAttribute = super.getAttribute(newContactFormTextBox, "placeholder");
			
			contactDetails.forEach((key,value)->{
				if(getCurrentTextBoxAttribute.equalsIgnoreCase(key)) {
					super.sendKey(newContactFormTextBox, value);
				}
			});
					
		}
	}
	
}
