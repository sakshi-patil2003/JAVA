package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.AadharcardDTO;
import com.hibernate.dto.PersonDTO;

public class PersonDAO {

	private static EntityManagerFactory  entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
	AadharcardDTO aadharcardDTO=new AadharcardDTO();
	aadharcardDTO.setAadharno(112233445566l);
	aadharcardDTO.setAddress("Songir tal-dist: Dhule");
	
	PersonDTO dto=new PersonDTO();
	dto.setAadharcardDTO(aadharcardDTO);
	dto.setName("Dadu Patil");
	dto.setMobile(8767659742l);
	
	openConnection();
	entityTransaction.begin();
	entityManager.persist(aadharcardDTO);
	
	
	entityTransaction.commit();
	
	entityTransaction.begin();
	entityManager.persist(dto);
	entityTransaction.commit();
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
