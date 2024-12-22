package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.UserDTO;

public class UserDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		UserDTO userDTO=new UserDTO();
		userDTO.setId(4);
		userDTO.setName("sonu");
		userDTO.setEmail("sonu@gmail.com");
		userDTO.setMobile(4785963214l);
		userDTO.setPassword("sb@123");
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDTO);
		System.out.println(userDTO);
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
		if(entityTransaction!=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
	
}


