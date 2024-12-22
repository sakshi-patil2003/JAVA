package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.CheifMinister;

public class StateDAOUpdate {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openconnection();
		CheifMinister cheifMinister = entityManager.find(CheifMinister.class, 1);
		cheifMinister.getName();
		cheifMinister.setName("Eknath Sambhaji Shinde");
		
		entityTransaction.begin();
		entityManager.persist(cheifMinister);
		entityTransaction.commit();
		
		closeConnection();
		
	}
	private static void openconnection() {
	
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
