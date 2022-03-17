package com.crm.OrganizationTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateOrgWithMultipleDataTest {
	//Create object for all utilities
			PropertyFileUtility plib=new PropertyFileUtility();
			ExcelFileUtility elib=new ExcelFileUtility();
			WebDriverUtility wlib=new WebDriverUtility();
			JavaUtility jlib=new JavaUtility();

	@Test
	public void createOrgWithMultipleData()
	{
		
		
		//Read data from property file
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String BROWSER = plib.readDataFromPropertyFile("browser");
		
		//Launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Navigate to Organization
		HomePage hp=new HomePage(driver);
		hp.clic
		
		//Create org
		
		//Create new org
		
		//
		
		//Validate
		
	}
	@DataProvider(name="OrgtestData")
	public Object[][] getData()
	{
	data=elib.readDataFromExcel(Sheetname, rowno, celno)
	
	}
}
