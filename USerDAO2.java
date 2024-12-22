package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.UserDTO;

public class USerDAO2 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userDTO=entityManager.find(UserDTO.class,1);
		if(userDTO!=null)
			System.out.println(userDTO);
		else
			System.out.println("User Not Found");
		closeConnection();
	
	}
	private static void openConnection() {
		entityManagerFactory= Persistence.createEntityManagerFactory("hibernate");
		entityManager= entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
		if(entityTransaction!=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
}
