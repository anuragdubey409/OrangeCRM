package com.crm.hubspot.Pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.hubspot.DriverUtils.DriverHelper;

public class DashboardPage extends DriverHelper {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[@class='show-heading-dashboard']/h3")
	private WebElement marketingDashboardText;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left be-user-nav topmenu-nav']/li")
	private List<WebElement> MenuBar;
	
	
	
	/**
	 * Verify Dashboard Page
	 */
	public void verifyDashobardPage(String dashboardText) {
		
	}

	/**
	 * Navigate To Menu
	 * 
	 * @param <T>
	 * @param Menu      :- Pass The Name of Menu
	 * @param className
	 * @return
	 */
	public <T> T navigateToMenu(String Menu,String SubMenu , Class<T> className) {
		int count = MenuBar.size();
		for(int i=2;i<=count;i++) {
			String getMenuBarName = "//ul[@class='nav navbar-nav navbar-left be-user-nav topmenu-nav']/li["+i+"]/a";
			String menuBarText = super.getText(getMenuBarName);
			if(StringUtils.isNotEmpty(menuBarText)  && Menu.equalsIgnoreCase(menuBarText)) {
				super.clickOn(getMenuBarName);
			}
			
			if(StringUtils.isNotEmpty(SubMenu)) {
			int subMenuSize = super.getSize(getMenuBarName.concat("/following-sibling::ul/li"));
			for(int j=1 ; j<= subMenuSize;j++) {
				String subMenuBarLocator = getMenuBarName.concat("/following-sibling::ul/li["+j+"]/a");
				String subMenuText = super.getText(subMenuBarLocator);
				if(StringUtils.isNotEmpty(subMenuText) && SubMenu.equalsIgnoreCase(subMenuText)) {
					super.clickOn(subMenuBarLocator);
				}
			}
		}
	}	
		return (T) PageFactory.initElements(driver, className);
	}
	
	/**
	 * Verify Dashboard
	 * @param text
	 */
	public void verifyDashboard(String text) {
		wait.waitForElementToBeVisible(marketingDashboardText);
		String dashboardText = super.getText(marketingDashboardText);
		if(StringUtils.isNotEmpty(dashboardText)) {
			Assert.assertEquals(dashboardText, text);
		}
	}
	
	
}
	 
	
