package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert2 {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id ");
		int id =scanner.nextInt();
		
		System.out.println("Enter Name ");
		String name =scanner.next();
		
		System.out.println("Enter Email ");
		String email =scanner.next();
		
		System.out.println("Enter MobileNo ");
		long mob =scanner.nextLong();
		
		System.out.println("Enter Password ");
		String pass =scanner.next();
		try {
			openconnection();
			query="INSERT INTO USERS VALUES(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, mob);
			preparedStatement.setString(5, pass);
			int row=preparedStatement.executeUpdate();
			System.out.println(row+" rows affected");
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
