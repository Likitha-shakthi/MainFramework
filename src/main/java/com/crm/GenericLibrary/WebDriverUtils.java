package com.crm.GenericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	//Maximize window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	//Wait for page to load
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//Wait for page element to be clickable
	public void waitForElementToBeClickable(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	//wait for element to be visible
	public void waitForElementToBeVisbible(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	//Handling dropdown using select by index
	public void select(WebElement ele, int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}

	//Handling dropdown using select by value
	public void select(String value, WebElement ele)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}
	//.Handling drop down using sleect by visible text
	public void select(WebElement ele, String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	//Handling mouse hover actions
	public void mouseHoverActions(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	//Handling drag and drop
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
	Actions act=new Actions(driver)	;
	act.dragAndDrop(src, dst).perform();
	}
	
	//Handling double click on webpage
	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	//Handloing double click on webelement
	public void doubleClick(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	//Handling right click on webpage
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	//Handling right click on webelement
	public void rightClick(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick(ele);
	}
	
	public void switchToFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
}




































