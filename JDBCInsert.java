package com.sakshi.jdbc;

//Importing the required packages
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {
	
	//Make the objects globally which are mandatory
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;

	//Declare a query variable as a String 
	private static String query;
	
	public static void main(String[] args) {
		//Here we used try catch block because in openConnection method we throws the exception 
		try {
			openConnection();
			statement=connection.createStatement();
			
			//Initialized the query
			query="INSERT INTO USERS VALUES(101,'SAKSHI','sap@123.com',1236547890,'sakshi@2003')";
			statement.execute(query);
			
			//Process the result
			System.out.println("Record is inserted successfully");
			
		} catch (ClassNotFoundException | SQLException e)  //In catch block we handle the more than one exception
		{
			e.printStackTrace();
		}
		//In any how condition we close the connection for that purpose we used finally block because finally block is executed whether exception is occurred or not
		finally {
			try {
				closeConnection();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//In this method we load and register the driver
	
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");
		
	}
	private static void closeConnection() throws SQLException {
		if(statement!=null) {
			statement.close();
		if(connection!=null)
			connection.close();
		if(driver!=null)
			DriverManager.deregisterDriver(driver);
		}
	}
}
