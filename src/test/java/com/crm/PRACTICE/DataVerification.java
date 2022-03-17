package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerification 
{

	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
	  String expect = "1";
		
		Connection con=null;
		try{
		//step1: register the database 
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		// step2: get connector from the db- provide data base name
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		// step3: issue create statement
		Statement state = con.createStatement();
		//step4: execute query 
		ResultSet result = state.executeQuery("select * from student;");
		while(result.next())
		{
			String actuData = result.getString(1);
			if(expect.equalsIgnoreCase(actuData))
			{
				System.out.println("verified");
				break;
			}
			else
			{
				System.out.println("not verified");
				break;
			}
		}
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		finally 
		{
			
			con.close();
			System.out.println("success");
		}
		
	}

}
