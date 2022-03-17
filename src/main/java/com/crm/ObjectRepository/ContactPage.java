package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactPage extends WebDriverUtility{
	
	//Step1: Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreatecontactLooKUpImg;
	
	//Step2: Intialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Step3: Utilization
	public WebElement getCreatecontactLnk() {
		return CreatecontactLooKUpImg;
	}
	
	//Step4: Business library
	public void createContactTest()
	{
		CreatecontactLooKUpImg.click();
	}
	
	
	

}
