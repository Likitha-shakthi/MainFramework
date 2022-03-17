package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.*;
import com.crm.ObjectRepository.*;

public class OrgTestSelectMultipleCheckBoxes extends BaseClass
{
	
	@Test
	public void orgTestCheckBoxes() throws Throwable
	{
		//String OrgName = eLib.readDataFromExcel("Org", 1, 2);
	//click on organization link
	HomePage hp=new HomePage(driver);
	hp.Organizations();
	
	//Navigate to organization page
	OrganizationPage op=new OrganizationPage(driver);
	op.createOrganization();
	
	
	driver.findElement(By.xpath("//table[@class='lvt small']"));
	

	
	
	}
	
	
}
