package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{
	//Step1: Declaration
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//Step2: Intialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step3: Utilization
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	/**
	 * This method is used to login to the application
	 * @param Uname
	 * @param Pwd
	 */
	//Step4: Business Library
	public void loginToApp(String Uname, String Pwd)
	{
		UsernameEdt.sendKeys(Uname);
		PasswordEdt.sendKeys(Pwd);
		LoginBtn.click();
	}
	

}









