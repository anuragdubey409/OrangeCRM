package com.crm.hubspot.Pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.hubspot.Utils.DriverHelper;

public class DashboardPage extends DriverHelper{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[class='head']>h1")
	private WebElement dashboardLink;
	
	@FindBy(css = "ul[id='mainMenuFirstLevelUnorderedList']>li")
	private List<WebElement> MenuBar; 
	
	/**
	 * Verify Dashboard Page                                                          
	 */
	public void verifyDashobardPage(String dashboardText) {
		super.verifyText(dashboardLink,dashboardText);
	}		
	
	/**
	 * Navigate To Menu
	 * @param <T>
	 * @param Menu :- Pass The Name of Menu
	 * @param className
	 * @return
	 */
	public <T> T navigateToMenu(String Menu,Class className){
		int MenuBarSize = MenuBar.size();
		for(int i=1;i<=MenuBarSize;i++) {
			String getMenuText = super.getText("css=ul[id='mainMenuFirstLevelUnorderedList']>li:nth-child("+i+")>a>b");
			if(StringUtils.isNotEmpty(getMenuText) && Menu.equalsIgnoreCase(getMenuText)) {
				super.clickOn("css=ul[id='mainMenuFirstLevelUnorderedList']>li:nth-child("+i+")>a");
			}
		}
		return (T) PageFactory.initElements(driver, className);
	}
	
}
