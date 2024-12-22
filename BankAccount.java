package com.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BankAccount {

	@Id
	@GeneratedValue
	private int id;
	private long accountNumber;
	private String bankName;
	@ManyToOne
	private BankAccountHolder bankAccountHolder;
}
