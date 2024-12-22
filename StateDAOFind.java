package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.CheifMinister;

public class StateDAOFind {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		openconnection();
		CheifMinister cheifMinister = entityManager.find(CheifMinister.class,4);
		if(cheifMinister!=null) {
		cheifMinister.getName();
		System.out.println(cheifMinister);
		}
		else
			System.out.println("Not found");
		closeConnection();
	}
	
	private static void openconnection() {
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
