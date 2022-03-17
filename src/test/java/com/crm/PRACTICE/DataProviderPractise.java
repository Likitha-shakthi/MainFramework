package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise
{
	@Test(dataProvider="getData")
	public void sampleDataProvider(String name, String model, int qty)
	{
		System.out.println(name+"----"+model+"------"+qty);
		
	}
	@DataProvider 
	public  Object[][] getData()
	{
		Object obj[][]=new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="Note 7 pro";
		obj[0][2]=23;
	
		obj[1][0]="Vivo";
		obj[1][1]="11 max pro";
		obj[1][2]=13;
		
		obj[2][0]="Samsung";
		obj[2][1]="11 min pro";
		obj[2][2]=10;
		
		obj[3][0]="Micromax";
		obj[3][1]="10 max pro";
		obj[3][2]=45;
		
		return obj;
		
	}

}
