package com.micro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	
	@NotNull(message = "Course name cannot be null")
	private String courseName;
	
	@NotNull(message = "course duration cannot be null")
	@Min(value = 1, message = "Course duration can not be less than 1 year")
	private Integer courseDuration;

	public Course() {
		super();
	}

	public Course(Integer courseId, @NotNull(message = "Course name cannot be null") String courseName,
			@NotNull(message = "course duration cannot be null") @Min(value = 1, message = "Course duration can not be less than 1 year") Integer courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public Course(@NotNull(message = "Course name cannot be null") String courseName,
			@NotNull(message = "course duration cannot be null") @Min(value = 1, message = "Course duration can not be less than 1 year") Integer courseDuration) {
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
