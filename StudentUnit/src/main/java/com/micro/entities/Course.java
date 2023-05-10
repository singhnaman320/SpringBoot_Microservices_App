package com.micro.entities;

//It is created so that we can access another microservice course from student microservice
public class Course {

	private Integer courseId;          
	private String courseName;      
	private Integer courseDuration;
	
	public Course() {
		super();
	}

	public Course(Integer courseId, String courseName, Integer courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public Course(String courseName, Integer courseDuration) {
		super();
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ "]";
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}
	
}
