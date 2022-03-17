package com.crm.ContactSelectTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContSelectTest 
{
	@Test
public void createContactTest() throws InterruptedException
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
	
	//Step 3: navigate to Contacts link
	
	driver.findElement(By.linkText("Contacts")).click();
	
	//Step 4: click on create Contacts link
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	//Step 5:create Contact with mandatory fields
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='lastname']")).sendKeys("abcde");
	
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	Thread.sleep(2000);
	 String win = driver.getWindowHandle();
	driver.switchTo().window("5298FD193C327C4F7C0A73F381483BCD");
	//driver.findElement(By.id("1")).click();
	
	//Step 6: Save
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	
	driver.close();
}
}
