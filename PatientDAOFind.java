package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.DNAReport;


public class PatientDAOFind {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		openConnection();
		DNAReport dnaReport = entityManager.find(DNAReport.class, 1);
		if(dnaReport!=null)
			System.out.println(dnaReport);
		else
			System.out.println("Not found");
		
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory= Persistence.createEntityManagerFactory("hibernate");
		entityManager= entityManagerFactory.createEntityManager();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
	}
}
