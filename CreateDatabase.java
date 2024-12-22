package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateDatabase {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
		Statement statement=connection.createStatement();
		
		statement.execute("create database demo");
		
		System.out.println("Database is created successfully");
		
		connection.close();
		statement.close();
		
		DriverManager.deregisterDriver(driver);
	}
}


