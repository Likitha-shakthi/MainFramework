package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility
{
	
    //Step1: Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//Intialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreatecontactLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Business Library
	public void createOrganization()
	{
		createOrgLookUpImg.click();
	}
	
	
}
