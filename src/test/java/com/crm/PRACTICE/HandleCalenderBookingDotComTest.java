package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleCalenderBookingDotComTest {

	@Test
	public void calender()
	{
		String monthyear="August 2022";
		String checkindate="12";
		String checkoutdate="14";
		String month="August 2022";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://sp.booking.com/");
		
		//Actions actions=new Actions(driver);
		//actions.moveByOffset(10, 10).click().perform();
		
		
		driver.findElement(By.xpath("//div[@class='xp__dates-inner']")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[.='"+month+"']")).click();
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//div[@data-bui-ref='calendar-next']")).click();
			}
		}
		
		
		driver.findElement(By.xpath("//div[.='"+monthyear+"']/ancestor::div[@class='bui-calendar__wrapper']/descendant::span[.='"+checkindate+"']")).click();
		driver.findElement(By.xpath("//div[.='"+monthyear+"']/ancestor::div[@class='bui-calendar__wrapper']/descendant::span[.='"+checkoutdate+"']")).click();
		
		
		
		driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("kerala");
		
		Actions actions=new Actions(driver);
		 WebElement ele = driver.findElement(By.xpath("//li[@role='option'][2]"));
		actions.moveToElement(ele).click().perform();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		
		driver.quit();
		
		
		
	}
}
