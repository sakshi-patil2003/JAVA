package com.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.Student;
import com.hibernate.dto.Subjects;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		Subjects subject1=new Subjects();
		subject1.setName("SQL");
		subject1.setFees(1000);
		
		Subjects subject2=new Subjects();
		subject2.setName("CORE JAVA");
		subject2.setFees(2000);
		
		Subjects subject3=new Subjects();
		subject3.setName("React");
		subject3.setFees(50000);
		
		List<Subjects> subjects=new ArrayList<Subjects>();
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);
		
		Student student1=new Student();
		student1.setName("Vaishnavi");
		student1.setEmail("vb@gmail.com");
		student1.setMobile(9764156842l);
		student1.setSubject(subjects);
		
		Student student2=new Student();
		student2.setName("Rohit");
		student2.setEmail("rohit@gmail.com");
		student2.setMobile(1254784730l);
		student2.setSubject(subjects);
		
		Student student3=new Student();
		student3.setName("Raj");
		student3.setEmail("raj@gmail.com");
		student3.setMobile(123654789l);
		student3.setSubject(subjects);
		
		entityTransaction.begin();
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityManager.persist(subject3);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
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
