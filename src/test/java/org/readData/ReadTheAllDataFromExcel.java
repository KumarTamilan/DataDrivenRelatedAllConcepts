package org.readData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTheAllDataFromExcel {

	public static void main(String[] args) throws IOException {
		File f = new File(".\\Excel\\Tools Versions.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		int numberOfSheets = wb.getNumberOfSheets();
		System.out.println(numberOfSheets);
		for(int i=0; i<numberOfSheets; i++) {
			String name = wb.getSheetName(i);
			System.out.println(name);
		}
	
		Sheet sheet = wb.getSheet("Tools Versions");
	
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for(int i=0; i<physicalNumberOfRows; i++) {
			int physicalNumberOfCells = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j=0; j<physicalNumberOfCells; j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String value = formatter.formatCellValue(cell);
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
