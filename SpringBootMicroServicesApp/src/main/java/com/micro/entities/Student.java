package com.micro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	
	@NotNull(message = "Student name cannot be null")
	private String name;
	
	@NotNull(message = "Student address cannot be null")
	private String address;
	
	@NotNull(message = "Student marks cannot be null")
	@Min(value = 0, message = "Student marks can not be negative")
	private Integer marks;
	
	@NotNull(message = "Student courseId cannot be null")
	@Min(value = 0, message = "Student courseId can not be zero or negative")
	private Integer courseId;
	
	@NotNull(message = "Student mobile number cannot be null")
	@Pattern(regexp = "[7986]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobileNumber;
	
	public Student() {
		super();
	}

	public Student(Integer roll, String name, String address, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.marks = marks;
	}
	
	public Student(String name, String address, Integer marks) {
		super();
		this.name = name;
		this.address = address;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + ", marks=" + marks + "]";
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
}
