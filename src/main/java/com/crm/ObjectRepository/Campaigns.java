package com.crm.ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class Campaigns 
{
	//Step1: Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CreateCampaignLookUpImgLnk;

	//Step2:Intialization
	public Campaigns(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step3: Utilization
	public WebElement getCreateCampaign()
	{
		return CreateCampaignLookUpImgLnk;
	}
	
	//step4: Business Library
	public void campaignTest()
	{
		CreateCampaignLookUpImgLnk.click();
	}
}












