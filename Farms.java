package com.hibernate.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Farms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double length;
	private double width;
	private String owner;
	@ManyToMany
	
	private List<Crops> crops;
}
