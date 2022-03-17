package com.crm.PractiseWithGenericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest
{
	public static void main(String[] args) throws Throwable
	{
			
		//Read all common data from property file
		PropertyFileUtility plib=new PropertyFileUtility();
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		
		JavaUtility jlib=new JavaUtility();
		
		//Read data from excel sheet
		ExcelFileUtility elib=new ExcelFileUtility();
		String OrgName = elib.readDataFromExcel("Org", 1, 2)+ " "+jlib.getRandomNumber();
		//=elib.readDataFromExcel("Org", 4, 2);
		
		//Launch the browser
	WebDriver driver=null;
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
			System.out.println("Invalid Browser");
		}
		
		//Here we will be using webdriver generic methods
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
	    driver.get(URL);
	    
	    //Login to the application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(OrgName);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	   //Here we use webdriver generic methods for mousehover action
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mousehoverActions(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
	    
		
	}

}
