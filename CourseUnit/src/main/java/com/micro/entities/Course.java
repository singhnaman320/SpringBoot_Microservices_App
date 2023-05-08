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
	@Min(value = 3, message = "Course duration can not be less than 3 months")
	private Integer courseDuration;
}
