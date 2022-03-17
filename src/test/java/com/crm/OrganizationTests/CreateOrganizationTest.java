package com.crm.OrganizationTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrganizationTest 
{
	@Test
	public void createOrganizationTest()
	{
		//step1: launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//step2: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");	
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: navigate to organizations link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		//Step 4: click on create Organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Assert.fail();
		
		//Step 5:create org with mandatory fields
		driver.findElement(By.xpath("//input[@type='text' and @class='detailedViewTextBox' and @name='accountname']")).sendKeys("abcde");
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		driver.close();
	}
}
