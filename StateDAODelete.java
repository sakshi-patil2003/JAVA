package com.hibernate.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.CheifMinister;

public class StateDAODelete {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction  entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		CheifMinister cheifMinister = entityManager.find(CheifMinister.class,1);
		if(cheifMinister!=null) {
			cheifMinister.getName();
			
		}
		else
			System.out.println("Not found");
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
