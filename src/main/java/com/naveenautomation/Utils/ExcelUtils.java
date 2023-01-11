package com.naveenautomation.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	

	public static FileInputStream fi;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String sheetName) throws IOException {

		int rowCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the sheet from Work book
		ws = wb.getSheet(sheetName);
		// Get the last row.
		rowCount = ws.getLastRowNum();

		wb.close();
		fi.close();

		return rowCount;

	}

	public static int getColumnCount(String xFile, String sheetName, int rowNo) throws IOException {

		int colCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the last row.
		ws = wb.getSheet(sheetName);

		row = ws.getRow(rowNo);
		colCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return colCount;

	}

	public static String getCellValue(String xFile, String sheetName, int rowNo, int colCount) throws IOException {

		String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);
		data = new DataFormatter().formatCellValue(cell);

		return data;

	}
	
	@DataProvider(name = "LoginDataProvider", parallel = false)
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data/LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}


