package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.Departments;

public class CollegeDAODelete {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
public static void main(String[] args) {
		Departments departments = entityManager.find(Departments.class,1);
		openConnection();
		entityTransaction.begin();
		entityManager.remove(departments);
		entityTransaction.commit();
		closeConnection();	
		
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
		if(entityTransaction.isActive())
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
}
