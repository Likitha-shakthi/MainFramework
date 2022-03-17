package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CreateCampaignsPage 
{
	//Step1: Declaration
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step2: Intialization
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step3: Utilization
	public WebElement getcreateCampaignname()
	{
		return CampaignNameEdt;
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	
	//Step4: Business Library
	public void createCampaignTest(String campname)
	{
		CampaignNameEdt.sendKeys(campname);
		SaveBtn.click();
	}
	
}














