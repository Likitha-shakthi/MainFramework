package com.crm.ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunitiesPage
{
    //Step1:Declaration
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement OppoNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step2: Intitalization
	public CreateOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step3: Utilization
	public WebElement getOppoNameEdt() {
	   return OppoNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Step4: Business Library
	public void createOpportunity(String OppName)
	{
		OppoNameEdt.sendKeys(OppName);
		SaveBtn.click();
	}
	
	
	
}
