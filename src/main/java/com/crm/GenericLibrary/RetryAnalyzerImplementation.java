package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer
{

	int count=0;
	int retryCount=4; // Running the script continously 4 times
	
	public boolean retry(ITestResult arg0)
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
