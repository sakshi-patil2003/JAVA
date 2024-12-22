package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateUSer {
	
	
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement=connection.createStatement();
//			query="INSERT INTO USERS VALUES(103,'Rohit','rp@123.com',7458963214,'rohit@1234')";
			query="Update users set password='deep@1997' where name='Deepp'";
			statement.execute(query);
		
			
			System.out.println("Record is updated successfully");
		} catch (SQLException | ClassNotFoundException e) {
			
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
	public static void openConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();                                                                                                                                                                                                                                                                                                                                                                                                    
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost/demo?user=root&password=root");
	}
	public static void closeConnection() throws SQLException {
		if(connection!=null)
			connection.close();
		if(statement!=null)
			statement.close();
		if(driver!=null)
			DriverManager.deregisterDriver(driver);
	}
}

