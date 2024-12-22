package com.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.dto.BankAccount;
import com.hibernate.dto.BankAccountHolder;

public class BankDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

		public static void main(String[] args) {
			BankAccountHolder bankAccountHolder = new BankAccountHolder();
			bankAccountHolder.setName("Sakshi");
			bankAccountHolder.setMobile(9764156840l);
			
			BankAccount bankAccount1=new BankAccount();
			bankAccount1.setBankName("Union");
			bankAccount1.setAccountNumber(774488559966l);
			bankAccount1.setBankAccountHolder(bankAccountHolder);
			
			BankAccount bankAccount2=new BankAccount();
			bankAccount2.setBankName("SBI");
			bankAccount2.setAccountNumber(112233665544l);
			bankAccount2.setBankAccountHolder(bankAccountHolder);
			
			openConnection();
			entityTransaction.begin();
			entityManager.persist(bankAccountHolder);
			entityTransaction.commit();
			entityTransaction.begin();
			entityManager.persist(bankAccount1);
			entityTransaction.commit();
			entityTransaction.begin();
			entityManager.persist(bankAccount2);
			entityTransaction.commit();
			closeConnection();

		}

		private static void openConnection() {
			entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
		}

		private static void closeConnection() {
			if (entityManagerFactory != null)
				entityManagerFactory.close();
			if (entityManager != null)
				entityManager.close();
			if (entityTransaction != null) {
				if (entityTransaction.isActive())
					entityTransaction.rollback();
			}
		}
	}

