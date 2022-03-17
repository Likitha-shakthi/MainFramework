package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{
	@Test
	
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		//step1: register the database 
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// step2: get connector from the db- provide data base name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		// step3: issue create statement
		Statement state = con.createStatement();
		
		//step4: execute query 
		//insert into student values(6,'abc','male');
		int result = state.executeUpdate("insert into student values(7,'abc','male');");
		if(result==1)
		{
			System.out.println("added successfully");
		}
		else
		{
			System.out.println("not added");
			
		}
		con.close();
		
	}
}
