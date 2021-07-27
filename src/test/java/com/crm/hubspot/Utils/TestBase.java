package com.crm.hubspot.Utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.constant.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	protected WebDriver driver;
	protected PropertyFileUtils property;
	protected WebDriverManager webDriverManager;
	protected DriverHelper driverHelper;
				
	@BeforeSuite
	public void setup() {
		property = new PropertyFileUtils("testData.properties");
		String browser=property.readProperty("Browser");		
		if(StringUtils.isNotEmpty(browser)) {
			if(browser.equalsIgnoreCase(Browser.CHROME.getBrowser())) {
				this.initChromeBrowser();
			}else if(browser.equalsIgnoreCase(Browser.IE.getBrowser())) {
				this.initIEBrowser();
			}else if(browser.equalsIgnoreCase(Browser.FIREFOX.getBrowser())) {
				this.initFirefoxBrowser();
			}else if(browser.equalsIgnoreCase(Browser.Edge.getBrowser())){
				this.initEdgeBrowser();
			}
		}
		driverHelper = new DriverHelper(driver);
	}
	
	@BeforeTest
	public void navigateToBrowser() {
		String url=property.readProperty("Url");
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public <T> T loginToTheApplication(String userName , String pass,Class Classname) {
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys(userName);		
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();;
		return (T) PageFactory.initElements(driver, Classname);
	}
	
	
	
	
	public void initChromeBrowser() {	
		WebDriverManager.chromedriver().arch64().setup();
		ChromeOptions  option = new ChromeOptions();
		driver = new ChromeDriver();
	}
	
	
	public void initFirefoxBrowser() {
		
	}
	
	
	public void initIEBrowser() {
		
	}
	
	public void initEdgeBrowser(){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
}

