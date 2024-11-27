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

public class ReadTheSingleDataFromExcel {

	public static void main(String[] args) throws IOException {
		File f = new File(".\\Excel\\Tools Versions.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Tools Versions");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		DataFormatter formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
		System.out.println(value);
	}
}
