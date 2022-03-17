package com.crm.PractiseWithBaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.GenericLibrary.*;

public class CreateOrgWithIndType extends BaseClass
{
	@Test
	public void createOrgWithIndTest() throws Throwable
	{
	   String  OrName= eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
	   String indtype = eLib.readDataFromExcel("Org", 4, 3);
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.Organizations();
		 
		//Org link
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrganization();
		
		//Create org with industry type
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrgName(OrName, indtype);
		
		
	}

}
