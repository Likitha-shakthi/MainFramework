package com.crm.PractiseWithBaseClass;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.GenericLibrary.*;

public class CreateContactWithLeadSource extends BaseClass
{
	@Test
	public void createOrgWithIndTest() throws Throwable
	{
	   String  OrgName= eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
	   
	   //Step1: Create organization
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.Organizations();
		 
		//Org link
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrganization();
		
		//create new org
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrgName(OrgName);
		
		//Step2: Validation
		String expdata="";
		
		
	}
}
