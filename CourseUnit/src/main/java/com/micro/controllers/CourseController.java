package com.micro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entities.Course;
import com.micro.entities.Student;
import com.micro.exceptions.CourseNotFoundException;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.services.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	// 1. Registering Courses
	
		@PostMapping("/courses")
		public ResponseEntity<Course> registerCourseHandler(@Valid @RequestBody Course course) throws CourseNotFoundException{
			
			Course registerCourse = courseService.registerCourse(course);
			
			return new ResponseEntity<Course>(registerCourse, HttpStatus.CREATED);
			
		}
}
