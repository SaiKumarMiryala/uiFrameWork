package com.uiFramework.companyName.projectName.helper.excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	private Logger log = Logger.getLogger(ExcelHelper.class);

	public void getExcelData(String ExcelLocation, String SheetName) {
		try {
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(ExcelLocation));
			// create workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(SheetName);
			// count no.of active rows in the sheet
			int totalRow = sheet.getLastRowNum();
			// count active columns in the rows
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new String[totalRow][totalColumn];
		} catch (Exception e) {

		}
	}
}
