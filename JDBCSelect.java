package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {

	private static Statement statement;
	private static Connection connection;
	private static ResultSet resultSet;
	private static Driver driver;
	
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			
			statement=connection.createStatement();
			query="select * from users";
			statement.execute(query);
			resultSet=statement.getResultSet();
			
			while(resultSet.next()) {
			System.out.println("User Id: "+resultSet.getInt("id"));
			System.out.println("User Name: "+resultSet.getString("name"));
			System.out.println("User Email: "+resultSet.getString("email"));
			System.out.println("Mobile No: "+resultSet.getLong("mobile"));
			System.out.println("Password: "+resultSet.getString("password"));
			System.out.println("====================================");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");
		
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
