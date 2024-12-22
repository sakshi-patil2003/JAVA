package com.sakshi.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CrateDatabase3 {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			
			statement=connection.createStatement();
			query="create database test1";
			statement.execute(query);
			
			System.out.println("Database is created");
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private static void openConnection() throws ClassNotFoundException, SQLException, IOException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
//		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		
		File file = new File("D:\\j2ee.txt");
		FileReader fileReader=new FileReader(file);
		
		Properties properties=new Properties();
		properties.load(fileReader);
		connection=DriverManager.getConnection(properties.getProperty("url"), properties);
	}
	private static void closeConnection() throws SQLException {
		if(statement!=null)
			statement.close();
		if(connection!=null)
			connection.close();
		if(driver!=null)
		DriverManager.deregisterDriver(driver);
	}
	
}
