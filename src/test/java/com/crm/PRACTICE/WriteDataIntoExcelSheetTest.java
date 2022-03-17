package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest 
{
	@Test
	
	public void WriteDataIntoExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data.xlsx");
				
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		Row r = sheet.createRow(3);
		
		Cell c = r.createCell(3);
		
		c.setCellValue("aishu");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\data.xlsx");
		book.write(fos);
		
		
		
		
	}
}
