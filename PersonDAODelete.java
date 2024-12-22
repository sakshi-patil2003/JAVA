package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.AadharcardDTO;
import com.hibernate.dto.PersonDTO;

public class PersonDAODelete {

	private static EntityManagerFactory  entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	openConnection();
	PersonDTO dto =entityManager.find(PersonDTO.class, 5);
	AadharcardDTO aadharcardDTO=new AadharcardDTO();
	if(dto!=null) {	
	entityTransaction.begin();
	entityManager.remove(dto);
	entityManager.remove(aadharcardDTO);
	System.out.println("Remove Succeessfully");
	entityTransaction.commit();
	}
	
	closeconnection();
			
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeconnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
		if(entityTransaction!=null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		
	}
}
