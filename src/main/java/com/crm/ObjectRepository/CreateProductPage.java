package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	//Step1: Declaration
	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Step2:Intialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3:Utilization
	public WebElement getProductName()
	{
		return ProductNameEdt;
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	
	//Step4:Business Library
	public void createProduct(String prodname)
	{
		ProductNameEdt.sendKeys(prodname);
		SaveBtn.click();
	}

}
