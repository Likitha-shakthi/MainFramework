package com.crm.PractiseWithGroupsExecution;

import org.testng.annotations.*;

import com.crm.GenericLibrary.*;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;

public class CreateContactTest extends BaseClass 
{
	@Test(groups="smoke")
	public void createContactTest() throws Throwable
	{
		String Lname= eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		
		//Navigate to Contact page
		ContactPage cp=new ContactPage(driver);
		cp.createContactTest();
		
		//Navigate to create contact page
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(Lname);
		
		
		
	}

}
