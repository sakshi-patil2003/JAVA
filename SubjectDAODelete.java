package com.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hibernate.dto.Student;
import com.hibernate.dto.Subjects;

public class SubjectDAODelete {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	public static void main(String[] args) {
		openConnection();
		query=entityManager.createQuery("Select students from  Student students");
		@SuppressWarnings("unchecked")
		List<Student> students=query.getResultList();
		for (Student student : students) {
			Subjects subjectToBeDeleted=null;
			List<Subjects> subjects=student.getSubject();
			for (Subjects subject : subjects) {
				if(subject.getId()==2) {
					subjectToBeDeleted=subject;
					break;
				}	
			}
			if(subjectToBeDeleted!=null) {
				subjects.remove(subjectToBeDeleted);
				student.setSubject(subjects);
				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();
			}
		}
		
		Subjects subjects = entityManager.find(Subjects.class,2);
		if(subjects!=null) {
		entityTransaction.begin();
		entityManager.remove(subjects);
		entityTransaction.commit();
		closeConnection();
		}else
			System.out.println("Subject not found");
		
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
