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
	private Integer studentId;
	
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

	public Student(Integer studentId, @NotNull(message = "Student name cannot be null") String name,
			@NotNull(message = "Student address cannot be null") String address,
			@NotNull(message = "Student marks cannot be null") @Min(value = 0, message = "Student marks can not be negative") Integer marks,
			@NotNull(message = "Student courseId cannot be null") @Min(value = 0, message = "Student courseId can not be zero or negative") Integer courseId,
			@NotNull(message = "Student mobile number cannot be null") @Pattern(regexp = "[7986]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number") String mobileNumber) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.marks = marks;
		this.courseId = courseId;
		this.mobileNumber = mobileNumber;
	}

	public Student(@NotNull(message = "Student name cannot be null") String name,
			@NotNull(message = "Student address cannot be null") String address,
			@NotNull(message = "Student marks cannot be null") @Min(value = 0, message = "Student marks can not be negative") Integer marks,
			@NotNull(message = "Student courseId cannot be null") @Min(value = 0, message = "Student courseId can not be zero or negative") Integer courseId,
			@NotNull(message = "Student mobile number cannot be null") @Pattern(regexp = "[7986]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number") String mobileNumber) {
		super();
		this.name = name;
		this.address = address;
		this.marks = marks;
		this.courseId = courseId;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", address=" + address + ", marks=" + marks
				+ ", courseId=" + courseId + ", mobileNumber=" + mobileNumber + "]";
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
