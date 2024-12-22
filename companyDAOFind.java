package com.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.Company;
import com.hibernate.dto.Employee;

public class companyDAOFind {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	
	public static void main(String[] args) {
	openConnection();
//	Company company=entityManager.find(Company.class ,1);
//	Company company = entityManager.find(Company.class, 1);
	Company company = entityManager.find(Company.class, 1);
	
	//press ctrl+1
	if(company!=null)
	{
		System.out.println(company);
		List<Employee> employees= company.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	else
		System.out.println("something went wrong");
	closeConnetion();
	}
	

	
	private static void openConnection() {
		entityManagerFactory =Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	private static void closeConnetion() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();
	}
}
