package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	private XSSFWorkbook workBook;

	public ExcelDataProvider() {

		File sourceFile = new File(System.getProperty("user.dir") + "/TestData/Data.xlsx");
		try {
			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			workBook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			System.out.println("Unable to Read Excel File" + e.getMessage());
		}
	}

	public int getRowCount(String sheetName) {
		XSSFSheet workSheet = workBook.getSheet(sheetName);
		int rowCount = workSheet.getLastRowNum();
		// Try closing the Workbook and FileInputStream
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNumber) {
		XSSFSheet workSheet = workBook.getSheet(sheetName);
		XSSFRow row = workSheet.getRow(rowNumber);
		int cellCount = row.getLastCellNum();
		// Try closing the Workbook and FileInputStream
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNumber, int columnNumber) {
		XSSFSheet workSheet = workBook.getSheet(sheetName);
		XSSFRow row = workSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(columnNumber);

		DataFormatter dataFormatter = new DataFormatter();
		String cellData = dataFormatter.formatCellValue(cell);
		return cellData;
	}

}