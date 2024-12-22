
package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Methods {
		private static Driver driver;
		private static Connection connection;
		private static PreparedStatement preparedStatement;
		private static ResultSet resultSet;
		private static String query;
		
		public static void main(String[] args) {	
			try {
				openconnection();
				query="sort";
				preparedStatement=connection.prepareCall(query);
				
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				
				}
				
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
