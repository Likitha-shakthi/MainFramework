package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility
{

	//Step1: Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderInfoTxt;
	
	//Step2: Intialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step3: Utilization
	public WebElement getHeaderInfoTxt() {
		return HeaderInfoTxt;
	}
	
	//Step4: Business library
	public String orgNameInfo()
	{
		String actdata = HeaderInfoTxt.getText();
		return actdata;
	}
	
}













