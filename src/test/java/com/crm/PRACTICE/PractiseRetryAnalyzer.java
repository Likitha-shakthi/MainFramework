package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.*;

public class PractiseRetryAnalyzer {

	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	public void practiseRetry()
	{
		System.out.println("This is test1");
		Assert.fail();
		System.out.println("This is passed");
	}
}
