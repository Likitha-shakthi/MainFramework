package com.crm.PRACTICE;

import org.testng.annotations.*;

import com.crm.GenericLibrary.*;

public class BaseClassPractise extends BaseClass{
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("database connectivity established");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Launch the browser");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Login to app");
	}
	
	@Test
	public void actualTest()
	{
		System.out.println("Testscript -1");
	}
	
	@Test
	public void actualTest1()
	{
		System.out.println("Testscript -2");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("Logout of app");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("Close the browser");
	}
	
	@BeforeClass
	public void bcConfig1()
	{
		System.out.println("Launch the browser");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("Close database");
	}

}







