package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement OpportunityLookUpImg;
	
	//intialization(constructor
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOpportunityLookUpImg() {
		return OpportunityLookUpImg;
	}
	
	//Business Library
	public void createOpportunitiesTest()
	{
		OpportunityLookUpImg.click();
	}
	
	

}
