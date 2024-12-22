package com.sakshi.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/demo?user=root&password=root");
		
		
		
		Statement statement=connection.createStatement();
		//statement.execute("CREATE TABLE USERS (ID NUM PRIMARY KEY ,NAME VARCHAR(20) NOT NULL, EMAIL VARCHAR(20) UNIQUE NOT NULL, MOBILE BIGINT(10) UNIQUE NOT NULL)");
		statement.execute(
				"CREATE TABLE users1(id int primary key, name varchar(20) not null, email varchar(20) not null unique,"
				+ " mobile bigint(10) not null unique, password varchar(20) not null)");

		
		System.out.println("Table is created");
		
		connection.close();
		statement.close();
	}
}
