
package com.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hibernate.dto.Student;
import com.hibernate.dto.Subjects;

public class StudentDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	
	public static void main(String[] args) {
		openConnection();
		Student student = entityManager.find(Student.class,1);
		if(student!=null)
		{
			System.out.println(student);
			List<Subjects> subjects=student.getSubject();
			for (Subjects subjects2 : subjects) {
				System.out.println(subjects2);
			}
		}
		else
			System.out.println("Student not found");
		
		closeConnection();
		
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		
		
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
		if(entityManager!=null)
			entityManager.close();

			
	}
}
