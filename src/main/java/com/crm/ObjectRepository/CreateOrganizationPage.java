package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{

	//Step1: Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step2: Intialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
     
	//Step3: Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * This method is used to create organization with industry type
	 * @param OrgName
	 */
	//step4: Business Library
	public void createOrgName(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	public void createOrgName(String OrName, String indtype)
	{
		OrgNameEdt.sendKeys(OrName);
		select(industryDropDown, indtype);
		
		saveBtn.click();
	}
}
