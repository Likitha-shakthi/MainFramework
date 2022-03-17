package com.crm.PRACTICE;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PractiseTestNG {
	
	@Test
	public void createOrg()
	{
		System.out.println("Org created");
	}
	
	@Test
	public void deleteOrg()
	{
		Reporter.log("Org deleted", true);
	}

}
