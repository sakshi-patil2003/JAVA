package com.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.College;
import com.hibernate.dto.Departments;

public class CollegeDAOInsert {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		College college=new  College();
		college.setLoc("pune");
		college.setName("D.B.A.T.U. Lonere");
		
		Departments department1=new Departments();
		department1.setName("Computer");
		department1.setHOD("S P Patil");
		department1.setCollege(college);
		
		Departments department2=new Departments();
		department2.setName("Computer");
		department2.setHOD("S P Patil");
		department2.setCollege(college);
		
		Departments department3=new Departments();
		department3.setName("Computer");
		department3.setHOD("S P Patil");
		department3.setCollege(college);
		
		List<Departments> departments=new ArrayList<Departments>();
		departments.add(department1);
		departments.add(department2);
		departments.add(department3);
		college.setDepartment(departments);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(department1);
		entityManager.persist(department2);
		entityManager.persist(department3);
		entityManager.persist(college);
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
