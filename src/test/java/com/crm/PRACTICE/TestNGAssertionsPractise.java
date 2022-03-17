package com.crm.PRACTICE;

import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionsPractise {
	@Test
	public void assertionPractise()
	{
	
		SoftAssert sa=new SoftAssert();
			System.out.println("This is test1");
			sa.assertEquals(1, 0);
			
			System.out.println("passed");
			sa.assertAll();
			Assert.assertEquals(1, 0);
	}

}
