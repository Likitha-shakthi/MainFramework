package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	String path;
	
	public void onTestStart(ITestResult result) 
	{
	    
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"--------Testscript execution started");
		
		test=report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"--------Testscript execution successful- pass");
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"------------>Passed");
		
	}

public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName()+"-";
		Reporter.log(MethodName + "--- TestScript Failed",true);
		
		
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			//path = new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			
	
			EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			String path = "./Screenshots/"+screenshotName+".png";
			File dst = new File(path);
			Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, MethodName+"------------->Failed");
	
		//It will capture the exception and log into the report
		test.log(Status.SKIP, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	
	}
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"--------Testscript Skipped");
		
		test.log(Status.SKIP, MethodName+"-------->Skipped");
		//It will capture the exception and log it in report
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		//Execution will start here
		/*Configure the report*/
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("SDET30- Execution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Selenium Execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter name", "Likhitha");
		
	}

	public void onFinish(ITestContext context) 
	{

		//Consolidate all the parameters and generate the report
		report.flush();
	
	}
	

}

































