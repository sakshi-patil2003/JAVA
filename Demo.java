package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		Statement statement=connection.createStatement();
		statement.execute("create database sakshi");
		System.out.println("Database Created");
		connection.close();
		statement.close();
	}
}
