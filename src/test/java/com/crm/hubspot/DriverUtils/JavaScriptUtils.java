package com.crm.hubspot.DriverUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	private WebDriver driver;
	protected JavaScriptUtils(WebDriver driver) {
		this.driver = driver;
	}

	
	public JavascriptExecutor getJavaScriptExecutor() {
		return (JavascriptExecutor) driver;
	}
	
	public void clickUsingJavaScript(WebElement element) {
		this.getJavaScriptExecutor().executeScript("arguments[0].click();", element);
	}
	
	public void executeScript(String script,WebElement element) {
		this.getJavaScriptExecutor().executeScript(script, element);
	}
	
	
}
