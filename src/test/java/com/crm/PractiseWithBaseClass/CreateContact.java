package com.crm.PractiseWithBaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.crm.GenericLibrary.*;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContact extends BaseClass 
{
	@Test
	public void createContactTest() throws Throwable
	{
		String Lname= eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		
		//Navigate to Home page
		HomePage hp=new HomePage(driver);
		hp.Contacts();
		
		//Navigate to Contact page
		ContactPage cp=new ContactPage(driver);
		cp.createContactTest();
		
		//Navigate to create contact page
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(Lname);
		
		
		
	}

}
