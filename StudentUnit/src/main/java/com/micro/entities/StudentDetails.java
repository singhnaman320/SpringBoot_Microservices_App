package com.micro.entities;

// It is created so that we can access another microservice course from student microservice
public class StudentDetails {

	private Integer studentId;
	private String studentName;
	private String mobileNumber;
	private Integer courseId;
	private Course course;
	
	public StudentDetails() {
		super();
	}

	public StudentDetails(Integer studentId, String studentName, String mobileNumber, Integer courseId, Course course) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.courseId = courseId;
		this.course = course;
	}

	public StudentDetails(String studentName, String mobileNumber, Integer courseId, Course course) {
		super();
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.courseId = courseId;
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", mobileNumber="
				+ mobileNumber + ", courseId=" + courseId + ", course=" + course + "]";
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
