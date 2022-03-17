package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest
{
	@Test
	
	public void readDataFromExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		//step1: load excel file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		
		//step2: create workbook
		Workbook book = WorkbookFactory.create(fis);
		
		//step3: get the sheet
		
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4: get the row
		
		Row r = sheet.getRow(1);
		
		//step5: get the cell
		
		Cell c = r.getCell(1);
		
		// step6:
		
		String value = c.getStringCellValue();
		System.out.println(value);
		
		
		
	}
}

