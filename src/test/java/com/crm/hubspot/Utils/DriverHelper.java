package com.crm.hubspot.Utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DriverHelper {

	protected WebDriver driver;

	protected DriverHelper(WebDriver driver) {
		this.driver = driver;
	}

	public By byLocator(String webElement) {
		By element = null;
		if (webElement.startsWith("//")) {
			element = By.xpath(webElement);
		} else if (webElement.startsWith("css=")) {
			String ele = webElement.replace("css=", "");
			element = By.cssSelector(ele);
		} else if(webElement.startsWith("id=")) {
			String ele = webElement.replace("id=", "");
			element = By.id(ele);
		}
		return element;
	}

	/**
	 * Convert String to Webelement
	 * 
	 * @param Webelement
	 * @return
	 */
	public WebElement getWebElement(String Webelement) {
		return driver.findElement(byLocator(Webelement));
	}
	
	public List<WebElement> getWebElements(String element){
		return driver.findElements(byLocator(element));
	}

	/**
	 * Send Keys using locator as String
	 * 
	 * @param webElement
	 * @param keysToSend
	 */
	public void sendKey(String webElement, String keysToSend) {
		try {
			WebElement element = getWebElement(webElement);
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKey(WebElement element, String keysToSend) {
		try {
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOn(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Click On Webelement
	 * 
	 * @param element
	 */
	public void clickOn(String element) {
		try {
			WebElement ele = this.getWebElement(element);
			if (ele.isEnabled()) {
				ele.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement element) {
		String text = "";
		try {
			if (element.isDisplayed()) {
				text = element.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public String getText(String element) {
		String text = "";
		WebElement ele = this.getWebElement(element);
		try {
			if (ele.isDisplayed()) {
				text = ele.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public String getAttribute(String element,String attribute) {
		String attributeText = "";
		WebElement ele = this.getWebElement(element);
		try {
			if (ele.isDisplayed()) {
				attributeText = ele.getAttribute(attribute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeText;
	
	}
	
	
	public int getSize(String locatorCount) {
		List<WebElement> locator =  this.getWebElements(locatorCount);
		return locator.size();
	}

	public void verifyText(WebElement element, String textToVerify) {
		if (StringUtils.isNotEmpty(this.getText(element))) {
			Assert.assertEquals(this.getText(element), textToVerify);
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param option (Index="2" , VisibleText="" , Value="")
	 */
	public void SelectBy(String element ,String option) {
		WebElement ele = this.getWebElement(element);
		Select select = new Select(ele);
		if(option.startsWith("Index")) {
			String ind = option.replace("Index=", "");
			int index = Integer.parseInt(ind);
			select.selectByIndex(index);
		}else if(option.startsWith("VisibleText")) {
			String visible = option.replace("VisibleText=","");
			select.selectByVisibleText(visible);
		}else if(option.startsWith("Value")) {
			String value = option.replace("Value=","");
			select.selectByValue(value);
		}
	}
	
	public void SelectBy(WebElement element ,String option) {
		Select select = new Select(element);
		if(option.startsWith("Index")) {
			String ind = option.replace("Index=", "");
			int index = Integer.parseInt(ind);
			select.selectByIndex(index);
		}else if(option.startsWith("VisibleText")) {
			String visible = option.replace("VisibleText=","");
			select.selectByVisibleText(visible);
		}else if(option.startsWith("Value")) {
			String value = option.replace("Value=","");
			select.selectByValue(value);
		}
	}
	
	
}
