package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.hibernate.dto.PersonDTO;


public class UserDAOUpdate {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		PersonDTO dto=entityManager.find(PersonDTO.class,1);
		if(dto!=null) {
			dto.setMobile(7412589635l);
			entityTransaction.begin();
			entityManager.persist(dto);
			System.out.println(dto);
		}
		else
			System.out.println("Not update");
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
