package com.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.CheifMinister;
import com.hibernate.dto.State;

public class StateDAOInsert {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		CheifMinister cheifMinister=new CheifMinister();
		cheifMinister.setName("Eknath Shinde");
		cheifMinister.setEmail("eknath@123.gov.in");
		cheifMinister.setMobile(456317890l);
		cheifMinister.setSal(9000000);
		
		CheifMinister cheifMinister1=new CheifMinister();
		cheifMinister1.setName("Ajit Pawar");
		cheifMinister1.setEmail("aajit@123.gov.in");
		cheifMinister1.setMobile(741258963l);
		cheifMinister1.setSal(9000000);
		
		CheifMinister cheifMinister2=new CheifMinister();
		cheifMinister2.setName("Devendra Fadanvis");
		cheifMinister2.setEmail("fdn20@123.gov.in");
		cheifMinister2.setMobile(5823697410l);
		cheifMinister2.setSal(9000000);
		
		List<CheifMinister>ministers=new ArrayList<CheifMinister>();
		ministers.add(cheifMinister);
		ministers.add(cheifMinister1);
		ministers.add(cheifMinister2);
		
		State state=new State();
		state.setName("Maharashtra");
		state.setPopulation(70123647l);
		state.setCheifMinisters(ministers);
		
		entityTransaction.begin();
		entityManager.persist(cheifMinister);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(cheifMinister1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(cheifMinister2);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(state);
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
		if(entityTransaction.isActive())
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	}
	
	
}
