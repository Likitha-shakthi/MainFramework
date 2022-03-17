package com.crm.PractiseWithGenericLib;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunitiesTest 
{
	WebDriver driver=null;
	//Here creating object of generic library for all the necessary actions
	ExcelFileUtility elib=new ExcelFileUtility();
	JavaUtility jlib=new JavaUtility();
	PropertyFileUtility plib=new PropertyFileUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	//Read data from property 
	String BROWSER = plib.readDataFromPropertyFile("browser");
	String URL = plib.readDataFromPropertyFile("url");
	String USERNAME = plib.readDataFromPropertyFile("username");
	String PASSWORD = plib.readDataFromPropertyFile("password");
	
	//Read data from excelsheet for contact
	String Lname = elib.readDataFromExcel("Opportunity", 4, 2)+"_"+jlib.getRandomNumber();
	//String OrgName = elib.readDataFromExcel("Org", 1, 2)+"_"+jlib.getRandomNumber();
	String Campname = elib.readDataFromExcel("Opportunity", 8, 2)+"_"+jlib.getRandomNumber();
	
	
	//Launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("Invalid browser");
	}
	
	//Here using webdriver methods to wait for page to load and to maximize the window
	wlib.maximizeWindow(driver);
	wlib.waitForPageLoad(driver);
	driver.get(URL);
	
	//Login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    driver.findElement(By.id("submitButton")).click();
    
    //Create Contact
    driver.findElement(By.linkText("Contacts")).click();
    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    driver.findElement(By.name("lastname")).sendKeys(Lname);
    
    /*
    driver.findElement(By.xpath("//img[@alt='Select']")).click();
    driver.findElement(By.name("search_text")).sendKeys(OrgName);
    
    driver.findElement(By.name("search")).click();*/
    
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    //Contact verification
    String coninfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(coninfo.contains(Lname))
	{
		System.out.println(coninfo+"---->contact is saved");
	}
	else
	{
		System.out.println("Contact is not saved");
	}
	
	//Navigate to campaign and Create campaign with mandatory fields
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	driver.findElement(By.linkText("Campaigns")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
	driver.findElement(By.name("campaignname")).sendKeys(Campname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Campaign verification
	String campinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(campinfo.contains(Lname))
	{
		System.out.println(campinfo+"---->campaign is saved");
	}
	else
	{
		System.out.println("campaign is not saved");
	}
	
	//Navigate to opportunity
	driver.findElement(By.linkText("Opportunities")).click();
	driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
	String OpName = elib.readDataFromExcel("Opportunity", 1, 2);
	driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OpName);
	
	//method will be used for dropdown
	WebElement ele = driver.findElement(By.xpath("//select[@id='related_to_type']"));
	wlib.select(ele, "Contacts");
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	//used method for sWitching the windows
	wlib.switchToWindow(driver, "Contacts");
	driver.findElement(By.id("search_txt")).sendKeys(coninfo);
	driver.findElement(By.name("search")).click();
	if(coninfo.contains(Lname))
	{
		driver.findElement(By.linkText(Lname)).click();
	}
	else
	{
		System.out.println("");
	}
	
	//method will be used to select employee from leadsource dropdown
	WebElement ele1 = driver.findElement(By.name("leadsource"));
	wlib.select(ele1, "Employee");
	
	driver.findElement(By.xpath("//option[@value='Employee']")).click();
	
	//Select campign from campaign source 
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	wlib.switchToWindow(driver, "Campaigns");
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(Campname);
	if(campinfo.contains(Campname))
	{
		driver.findElement(By.linkText(Campname)).click();
	}
	else
	{
		System.out.println("");
	}
	
	driver.findElement(By.xpath("//input[@name='search']")).click();
	String header1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	//Campaign verification
	if(header1.contains(Campname))
	{
		System.out.println("campaign is created");
	}
	else
	{
		System.out.println("Campaign is not created");
	}
	
	//Logout of an application
	WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wlib.mousehoverActions(driver, ele1);
	driver.findElement(By.linkText("Sign Out")).click();
	}
}



















