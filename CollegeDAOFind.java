package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.Departments;

public class CollegeDAOFind {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager  entityManager;
	
	public static void main(String[] args) {
		openConnection();
		Departments department = entityManager.find(Departments.class,1);
		if(department!=null)
			System.out.println(department);
		else
			System.out.println("Not found");
		
		closeConnection();
		
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
	}
	
			
}

