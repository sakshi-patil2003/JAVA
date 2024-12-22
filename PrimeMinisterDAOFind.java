package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.PrimeMinister;

public class PrimeMinisterDAOFind {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		openConnection();
//		Country country = entityManager.find(Country.class,2);
//		if(entityManager!=null) 
//			System.out.println(country);
//		
//		else
//			System.out.println("Country not found");
		
		PrimeMinister primeMinister = entityManager.find(PrimeMinister.class,2);
		if(primeMinister!=null)
			System.out.println(primeMinister);
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
