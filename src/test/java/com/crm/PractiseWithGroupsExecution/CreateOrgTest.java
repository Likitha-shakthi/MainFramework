package com.crm.PractiseWithGroupsExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.crm.GenericLibrary.*;

import com.crm.GenericLibrary.*;
import com.crm.ObjectRepository.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest extends BaseClass
{
	@Test(groups = "smoke")
	public void createOrgTest() throws Throwable
	{
	String OrgName= eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
			WebDriver driver=null;
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.getOrgLnk().click();
			 
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.createOrganization();
		
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createOrgName(OrgName);
				
		}
	    
		
	}


