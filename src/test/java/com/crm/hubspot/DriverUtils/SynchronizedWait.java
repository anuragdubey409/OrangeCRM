package com.crm.hubspot.DriverUtils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.hubspot.GlobalUtils.PropertyFileUtils;
import com.google.common.base.Function;

public class SynchronizedWait {

	WebDriver driver;
	WebDriverWait wait;
	DriverHelper helper;
	Wait<WebDriver> Fluentwait;
	WebElement element;
	private long waitForElementPresent;
	private long waitForElementClickable;
	private long waitForElementVisible;

	protected SynchronizedWait(WebDriver driver) {
		this.driver = driver;
		PropertyFileUtils util = new PropertyFileUtils("testData.properties");
		waitForElementPresent = Long.parseLong(util.readProperty("waitForElementToBeVisible"));
		waitForElementClickable = Long.parseLong(util.readProperty("waitForElementToBeClickable"));
		waitForElementVisible = Long.parseLong(util.readProperty("waitForElementToBePresent"));
	}

	public void waitForElementToBeVisible(WebElement ele) {
		wait = new WebDriverWait(driver, waitForElementVisible);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementToBeVisible(String ele) {
		element = helper.getWebElement(ele);
		wait = new WebDriverWait(driver, waitForElementVisible);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToClickable(WebElement element) {
		wait = new WebDriverWait(driver, waitForElementClickable);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToClickable(String ele) {
		element = helper.getWebElement(ele);
		wait = new WebDriverWait(driver, waitForElementClickable);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBePresent(By Locator) {
		wait = new WebDriverWait(driver, waitForElementPresent);
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	}

	/**
	 * Fluent Wait
	 * @param element
	 */
	public void FluentWait(WebElement element) {
		Fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class);
											
		    wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
	}
}
