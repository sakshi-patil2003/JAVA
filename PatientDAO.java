package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.DNAReport;
import com.hibernate.dto.Patient;


public class PatientDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		Patient patient=new Patient();
		patient.setName("Deep");
		patient.setMobile(4578963210l);
		
		DNAReport dnaReport=new DNAReport();
		dnaReport.setDateOfIssue("01/03/2024");
		dnaReport.setContent("Loveria");
		dnaReport.setPatient(patient);
		
		patient.setDnaReport(dnaReport);
		
		entityTransaction.begin();
		entityManager.persist(dnaReport);
		entityManager.persist(patient);
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
