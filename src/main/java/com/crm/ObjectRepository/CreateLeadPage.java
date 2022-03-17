package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage 
{
	//Step1:Declaration
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement ComapnyNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step2: Intialization
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step3: Utilization
	public WebElement getLastname()
	{
		return LastNameEdt;
	}
	public WebElement getCompanyName()
	{
		return ComapnyNameEdt;
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	
	//Step4: Business Library
	public void createLeadPageTest(String Lname, String compname)
	{
		LastNameEdt.sendKeys(Lname);
		ComapnyNameEdt.sendKeys(compname);
		SaveBtn.click();
	}
	
	

}

















