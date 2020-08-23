package com.uiFramework.companyName.projectName.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.Resource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class ExcelHelper {

	private Logger log = Logger.getLogger(ExcelHelper.class);

	@SuppressWarnings("deprecation")
	public Object[][] getExcelData(String ExcelLocation, String SheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(ExcelLocation));
			// create workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(SheetName);
			// count no.of active rows in the sheet
			int totalRow = sheet.getLastRowNum() + 1;
			// count active columns in the rows
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn];

			Iterator<Row> rowIterator = sheet.rowIterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();

					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataSets[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j - 1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i - 1][j - 1] = cell.getCellFormula();
						break;

					default:
						System.out.println("No matching enum data type found");
						break;
					}
				}

			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void UpdateResultInExcel(String ExcelLocation, String SheetName, String TestCaseName, String Status) {
		try {
			FileInputStream file = new FileInputStream(new File(ExcelLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(SheetName);
			int TotalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < TotalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(TestCaseName)) {
					r.createCell(1).setCellValue(Status);
					file.close();
					log.info("Result is updated...");
					FileOutputStream out = new FileOutputStream(new File(ExcelLocation));
					workbook.write(out);
					out.close();
					break;
				}

			}

		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		ExcelHelper excelHelper = new ExcelHelper();
		String ExcelLocation = ResourceHelper.getResourcePath("src\\main\\resources\\configFile\\TestData.xlsx");
		/*
		 * Object data[][] = excelHelper.getExcelData(excelLocation, "Login");
		 * System.out.println(data);
		 */
		excelHelper.UpdateResultInExcel(ExcelLocation, "TestScripts", "Login", "PASS");
		excelHelper.UpdateResultInExcel(ExcelLocation, "TestScripts", "Registration", "PASS");
		excelHelper.UpdateResultInExcel(ExcelLocation, "TestScripts", "Add to Cart", "FAIL");
	}
}
