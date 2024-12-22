package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect2 {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter Id");
		int id=scanner.nextInt();
		try {
			openconnection();
			query="Select name,password from users where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getString("password"));
			}
			else
				System.out.println("Invalid Id");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		scanner.close();
	}
	
	private static void openconnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if(connection!=null)
			connection.close();
		if(driver!=null)
			DriverManager.deregisterDriver(driver);
		if(preparedStatement!=null)
			preparedStatement.close();
	}
}
