package com.crm.ContactTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithPropertyFileTest
{
	public void createContactTest() throws Throwable
	{
//Step 1: read data from property file 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		//Step 2: launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//step2: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");	
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to Contacts link
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: click on create Contacts link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5:create Contact with mandatory fields
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='lastname']")).sendKeys("abcde");
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		driver.close();
		
	}
}
