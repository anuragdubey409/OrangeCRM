package com.crm.hubspot.Utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	public void verifyText(WebElement element, String textToVerify) {
		if (StringUtils.isNotEmpty(this.getText(element))) {
			Assert.assertEquals(this.getText(element), textToVerify);
		}
	}
}
