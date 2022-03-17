package com.crm.PractiseWithPOM;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactTest 
{
	@Test
	public void createContactTest() throws Throwable
	{
		
		WebDriver driver=null;
		JavaUtility jlib=new JavaUtility();
		//Read data from Property file
		PropertyFileUtility plib=new PropertyFileUtility();
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		
		System.out.println(USERNAME +" "+PASSWORD);
		//Read data from Excelsheet
		ExcelFileUtility elib=new ExcelFileUtility();
		String LastName = elib.readDataFromExcel("Contacts", 1, 2)+ " "+jlib.getRandomNumber();
		
		
		//Launch the browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Click on Contacts link
		HomePage hp=new HomePage(driver);
		hp.Contacts(driver);
		
		//Click on create contact look up image link
		ContactPage cp=new ContactPage(driver);
		cp.createContactTest();
		
		//Create contact with mandatory fields
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(LastName);
		
		//Logout of the application
		hp.signOutOfApp(driver);
		
		//Close the browser
		driver.quit();
		
	}

}














