package com.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.Company;
import com.hibernate.dto.Employee;

public class CompanyDAODelete {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	
		openconnection();
		Company company = entityManager.find(Company.class, 3);
		if (company != null) {
			List<Employee> employees = company.getEmployees();
			entityTransaction.begin();
			entityManager.remove(company);
			entityTransaction.commit();
			for (Employee employee : employees) {
				entityTransaction.begin();
				entityManager.remove(employee);
				entityTransaction.commit();
			}
		} else
			System.out.println("Company not found");
		
		closeConnection();
		
	
	}
	
	private static void openconnection() {
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
