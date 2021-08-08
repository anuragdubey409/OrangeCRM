package com.crm.hubspot.GlobalUtils;

import java.io.File;
import java.io.FileWriter;

import com.opencsv.CSVWriter;

public class CSVUtils {

	
	File file ;
	FileWriter fileWriter;
	CSVWriter csvWriter;
	
	public CSVUtils(String fileName) {
		String csvPath = PropertyFileUtils.currentProjectPath()+"//src//test//resources//";
		file = new File(csvPath+fileName+".csv");
		if(file.exists()) {
			file.delete();
		}
	}
	
	public void writeCSVFile(String[] fileHeader,String[] fileParam) {
		try {
		fileWriter = new FileWriter(file);
		csvWriter = new CSVWriter(fileWriter);
		csvWriter.writeNext(fileHeader);
		csvWriter.writeNext(fileParam);
		csvWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
