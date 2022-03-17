package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise2
{
	@Test(dataProvider="getData")
	public void sampleDataProvider(String name, int qty)
	{
		System.out.println(name+"---"+qty);
		
	}
	@DataProvider 
	public  Object[][] getData()
	{
		Object obj[][]=new Object[6][2];
		
		obj[0][0]="Mi";
		obj[0][1]=23;
	
		obj[1][0]="Vivo";
		obj[1][1]=13;
		
		obj[2][0]="Samsung";
		obj[2][1]=10;
		
		obj[3][0]="Micromax";
		obj[3][1]=5;
		
		obj[4][0]="Nokia";
		obj[4][1]=15;
		
		obj[5][0]="Iphone";
		obj[5][1]=28;
		
		
		return obj;
		
	}

}
