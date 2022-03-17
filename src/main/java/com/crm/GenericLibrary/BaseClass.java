package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	//create Object of all utilities
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DatabaseUtility dLib=new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	  public static WebDriver sDriver;
	 public  WebDriver driver;
	  
	
	@BeforeSuite(groups="smoke")
    public void connectDatabase()
    {
		//dLib.dan();
		Reporter.log("Db connection successfull", true);
		System.out.println("Connect to db");
    }
	
   //@BeforeClass(groups="smoke")
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser() throws Throwable
	{
		//read data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
	
	//Create runtime polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		WebDriverManager. firefoxdriver().setup();
	}
	else
	{
		System.out.println("invalid browser");
	}
	 sDriver = driver;
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	Reporter.log("Browser launch succesful", true);
	}
 
	@BeforeMethod(groups="smoke")
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("Login to app sucessfully", true);
	}
	
	@AfterMethod(groups="smoke")
	public void logout()
	{
		HomePage hp=new  HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("Signout of the application successfully", true);
	}
	
	@AfterClass(groups="smoke")
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser closed successfully", true);
	}
	
	@AfterSuite(groups="smoke")
	public void closeDB()
	{
		//dlib.closedb();
		Reporter.log("Database close succesffulyy", true);
	}
	
}

















