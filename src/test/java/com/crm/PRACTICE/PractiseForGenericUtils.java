package com.crm.PRACTICE;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PractiseForGenericUtils {
	public static void main(String[] args) throws Throwable
	{
		    JavaUtility jlib=new JavaUtility();
			int ran = jlib.getRandomNumber();
			String dat = jlib.getSystemDateInFormat();
			String date = jlib.getSystemDate();
			System.out.println(ran + date);
			System.out.println(dat);
			
			PropertyFileUtility plib=new PropertyFileUtility();
			String brows = plib.readDataFromPropertyFile("browser");
			System.out.println(brows);
			
			ExcelFileUtility elib=new ExcelFileUtility();
			 String value = elib.readDataFromExcel("org", 3, 2);
			System.out.println(value);
		
	}

}
