package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleCalenderGoibiboTest {
	@Test
	public void calender()
	{
		Date date=new Date();
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		
		
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		
		for(;;){
		try
		{
		driver.findElement(By.xpath("//div[.='May 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='15']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		break;
	    
		}
		catch (Exception e) 
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}
		driver.findElement(By.linkText("Done")).click();
		

}
}
