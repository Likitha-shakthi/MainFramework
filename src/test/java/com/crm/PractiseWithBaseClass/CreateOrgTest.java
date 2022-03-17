package com.crm.PractiseWithBaseClass;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.GenericLibrary.*;

import com.crm.GenericLibrary.*;
import com.crm.ObjectRepository.*;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners( com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgTest extends BaseClass
{
	
	@Test
	public void createOrgTest() throws Throwable
	{
	        String OrgName= eLib.readDataFromExcel("OrgMultipleData", 1, 0)+jLib.getRandomNumber();

			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.Organizations();
			 
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.createOrganization();
			Assert.fail();
		
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createOrgName(OrgName);
				
		}

	    
		
	}


