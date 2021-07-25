package com.crm.constant;

public enum Browser {
		
	IE("ie"),CHROME("chrome"),FIREFOX("firefox"),Edge("edge");

	String browser;
	
	Browser(String browser) {
		this.browser = browser;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	
}
