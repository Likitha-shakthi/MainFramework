package com.crm.PractiseWithPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseLoginTest 
{
@Test
public void createOrg() throws Throwable
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
	String OrgName = elib.readDataFromExcel("Org", 1, 2)+ " "+jlib.getRandomNumber();
	
	
	//Launch the browser
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	//Login to the application
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	//Click on Organization link
	HomePage hp=new HomePage(driver);
	hp.Organizations(driver);
	
	//Click on create organization 
	OrganizationPage op=new OrganizationPage(driver);
	op.createOrganization();
	
	//create organization with mandatory fields
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.createOrgName(OrgName);
	
	//Verification
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actdata = oip.orgNameInfo();
	if(actdata.contains(OrgName))
	{
		System.out.println(actdata+ "Organization is created");
	}
	else
	{
		System.out.println("Organization is not created");
	}
	
	//Signout of application
	hp.signOutOfApp(driver);
	
	//close the browser
	driver.close();
	
	}

}






























