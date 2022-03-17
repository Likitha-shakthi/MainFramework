package com.crm.PractiseWithPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrgNameTest 
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
		String OrgName = elib.readDataFromExcel("Org", 1, 2)+ " "+jlib.getRandomNumber();
		String Indtype=elib.readDataFromExcel("Org", 4, 3)+ " "+jlib.getRandomNumber();
		
		
		//Launch the browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//click on Organization link
		HomePage hp=new HomePage(driver);
		hp.Organizations();
		
		// click on Create organization lookup image link
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrganization();
		
		//create organization
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrgName(OrgName,Indtype);
		
		//Organization information page
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actdata1 = oip.orgNameInfo();
		if(actdata1.equalsIgnoreCase(OrgName))
		{
			System.out.println("organame is selected");
		}
		else
		{
			System.out.println("Org name not selected");
		}
		
		
	
		//Click on Contacts link
		hp.Contacts();
		
		//Click on create contact look up image link
		ContactPage cp=new ContactPage(driver);
		cp.createContactTest();
		
		//Create contact with mandatory fields
		CreateContactPage ccp=new CreateContactPage(driver);
		//ccp.createContact(LastName);
		ccp.createContact(driver, LastName, OrgName);
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(OrgName))
		{
			
			driver.findElement(By.linkText(OrgName)).click();
			
		}
		else
		{
			System.out.println("");
		}
		
		
		//Logout of application
		hp.signOutOfApp(driver);

		//Close the window
		driver.quit();
}
	
}
	
	
	
	
	
	
	
