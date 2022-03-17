package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage
{
	//Step1: Declaration
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement CreateLeadLookUpImgLnk;

	//Step2: Intialization
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step3: Utilization
	public WebElement getCreateLeadImg()
	{
		return CreateLeadLookUpImgLnk;
	}
	
	//Step4: Business Library
	public void leadPageTest()
	{
		CreateLeadLookUpImgLnk.click();
	}
}



















