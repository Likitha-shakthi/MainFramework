package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	//Step1: Declaration
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step2: Intialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Step3: Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}
	
	
	public WebElement getSearchEdt() {
		return SearchEdt;
	}
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Step4: Business Library
	public void createContact(String Lname)
	{
		LastNameEdt.sendKeys(Lname);
		SaveBtn.click();
	}
	public void createContact(WebDriver driver, String Lname, String Orname)
	{
		LastNameEdt.sendKeys(Lname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(Orname);
		SearchBtn.click();
		driver.findElement(By.xpath("//span[text()='"+Orname+"']")).click();
		System.out.println(Orname);
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
	
}




















