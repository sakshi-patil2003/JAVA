package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.AadharcardDTO;
import com.hibernate.dto.PersonDTO;


public class PersonDAO2 {

	private static EntityManagerFactory  entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	PersonDTO dto=new PersonDTO();
	AadharcardDTO aadharcardDTO=new AadharcardDTO();
	
	openConnection();
	dto=entityManager.find(PersonDTO.class, 1);
	if(dto!=null)
		System.out.println(dto);
	else
		System.out.println("User not found");
	
	aadharcardDTO=entityManager.find(AadharcardDTO.class, 2);
	if(aadharcardDTO!=null)
		System.out.println(aadharcardDTO);
	else
		System.out.println("Not found");
	closeconnection();		
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
	
	}
	private static void closeconnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
	
		
	}
}
