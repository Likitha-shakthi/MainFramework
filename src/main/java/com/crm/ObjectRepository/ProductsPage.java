package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class ProductsPage 
{
	//Step1: Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductLookUpImg;
	
	//Step2: Intialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step3: Utilization
	public WebElement getCreateProductLookUpImg() {
		return CreateProductLookUpImg;
	}
	
	//Step4: Business Library
	public void productPage()
	{
		CreateProductLookUpImg.click();
	}
}
