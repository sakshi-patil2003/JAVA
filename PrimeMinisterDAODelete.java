package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.Country;

public class PrimeMinisterDAODelete {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
//		PrimeMinister primeMinister = entityManager.find(PrimeMinister.class,5);
//		primeMinister.getName();
//		 entityTransaction.begin();
//		 entityManager.remove(primeMinister);
//		 entityTransaction.commit();
		
		Country country = entityManager.find(Country.class,2);
		country.getName();
		entityTransaction.begin();
		entityManager.remove(country);
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
