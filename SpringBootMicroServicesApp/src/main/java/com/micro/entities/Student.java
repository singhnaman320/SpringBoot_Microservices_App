package com.micro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	private String name;
	private String address;
	private Integer marks;
	
	public Student() {
		super();
	}
	
	
}
