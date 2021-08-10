package com.crm.hubspot.GlobalUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.crm.constant.CreateContactHeader;
import com.crm.hubspot.Pages.ContactPage;
import com.crm.hubspot.beansUtil.ImportContactBean;
import com.opencsv.CSVWriter;

public class CSVUtils {

	File file;
	FileWriter fileWriter;
	CSVWriter csvWriter;
	ImportContactBean conactBean;

	public CSVUtils(String fileName) {
		conactBean = new ImportContactBean();
		String csvPath = PropertyFileUtils.currentProjectPath() + "//src//test//resources//";
		file = new File(csvPath + fileName + ".csv");
		if (file.exists()) {
			file.delete();
		}
	}

	public void writeCSVFile(List<String[]> fileParam) {
		try {
			fileWriter = new FileWriter(file);
			csvWriter = new CSVWriter(fileWriter);
			String fileHeader[] = { CreateContactHeader.Name.getHeader(), CreateContactHeader.Email.getHeader(),
					CreateContactHeader.Role.getHeader(), CreateContactHeader.Phone.getHeader() };
			csvWriter.writeNext(fileHeader);
			for(String[] arr : fileParam) {
			csvWriter.writeNext(arr);
			}
			csvWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
