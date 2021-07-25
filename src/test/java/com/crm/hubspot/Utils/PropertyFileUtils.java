package com.crm.hubspot.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {
	
	Properties prop;
	FileReader reader;
	
	public PropertyFileUtils(String fileName)  {
		try {
		String currentPath = this.currentProjectPath();
		String filePathcurrentPath = currentPath+"//src//test//resources//"+fileName;
		reader = new FileReader(filePathcurrentPath);
		prop = new Properties();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String readProperty(String key)  {
		String value="";
		try {
		prop.load(reader);
		value = prop.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static String currentProjectPath() {
		File f = new File("");
		return f.getAbsolutePath().replaceAll("\\\\", "//");
	}
	
	
}
