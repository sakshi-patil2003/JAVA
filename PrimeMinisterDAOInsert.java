package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.Country;
import com.hibernate.dto.PrimeMinister;

public class PrimeMinisterDAOInsert {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();

		PrimeMinister minister=new PrimeMinister();
		minister.setName("Donald Trump");
		minister.setEmail("dtrump@123gov.in");
		minister.setMobile(7412589631l);
		minister.setSal(9000000);
		
		Country country=new Country();
		country.setName("United State");
		country.setPincode(222222);
		country.setPopulation(7896412l);
		
		entityTransaction.begin();
		entityManager.persist(minister);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(country);
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
