package com.micro.entities;

// It is created so that we can access another microservice course from student microservice
public class StudentDetails {

	// Variable name must be same as main course and student unit to get proper response otherwise you will get null
	private Integer studentId;  
	private String name;
	private String mobileNumber;
	private Integer courseId;
	private Course course;
	
	public StudentDetails() {
		super();
	}

	public StudentDetails(Integer studentId, String name, String mobileNumber, Integer courseId, Course course) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.courseId = courseId;
		this.course = course;
	}

	public StudentDetails(String name, String mobileNumber, Integer courseId, Course course) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.courseId = courseId;
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", courseId=" + courseId + ", course=" + course + "]";
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
