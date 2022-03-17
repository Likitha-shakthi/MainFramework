package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Step1: Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrgLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignoutLnk;
	
	//Step2:Intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step3:Utilization
	public WebElement getOrgLnk() {
		return OrgLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	
	public WebElement getLeadLnk()
	{
		return LeadLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}
	
	public WebElement getAdministratorImg() {
	return AdministratorImg;
	}

	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}

	//Step4: Business Libraray
	public void Organizations()
	{
		OrgLnk.click();
	
	}
	public void Lead()
	{
		LeadLnk.click();
	}
	
	public void Contacts()
	{
		ContactsLnk.click();
	}
	
	public void Opportunities()
	{
		OpportunitiesLnk.click();
	}
	
	public void campaigns()
	{
		CampaignsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mousehoverActions(driver, AdministratorImg);
		SignoutLnk.click();
	}

}










