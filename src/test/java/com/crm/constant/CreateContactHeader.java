package com.crm.constant;

public enum CreateContactHeader {
	
	Name("Name"),Email("Email"),Role("Role"),Phone("Phone");
	
	String Header;
	
	CreateContactHeader(String header){
		this.Header = header;
	}
	
	public String getHeader() {
		return Header;
	}
	
}
