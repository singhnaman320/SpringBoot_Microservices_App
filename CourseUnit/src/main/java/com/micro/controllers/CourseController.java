package com.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entities.Course;
import com.micro.exceptions.CourseNotFoundException;
import com.micro.services.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courseDetails")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	// 1. Registering Courses
	
	@PostMapping("/courses")
	public ResponseEntity<Course> registerCourseHandler(@Valid @RequestBody Course course) throws CourseNotFoundException{
			
		Course registerCourse = courseService.registerCourse(course);
			
		return new ResponseEntity<Course>(registerCourse, HttpStatus.CREATED);
			
	}
	
	// 2. Getting all the Courses
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCoursesHandler() throws CourseNotFoundException{
			
		List<Course> gettingList= courseService.getAllCourses();
			
		return new ResponseEntity<List<Course>>(gettingList, HttpStatus.OK);
	}
		
	// 3. Updating Course details
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourseHandler(@Valid @RequestBody Course course) throws CourseNotFoundException{
			
		Course updateCourseDetails = courseService.updateCourse(course);
			
		return new ResponseEntity<Course>(updateCourseDetails, HttpStatus.ACCEPTED);
	}
	
	// 4. Delete Course by its Id
	
	@DeleteMapping("/courses/{Id}")
	public ResponseEntity<Course> deleteCourseByIdHandler(@PathVariable("Id") Integer courseId) throws CourseNotFoundException{
			
		Course deleteCourse = courseService.deleteCourseById(courseId);
			
		return  new ResponseEntity<Course>(deleteCourse, HttpStatus.ACCEPTED);
	}
	
	// 5. Get Course by its name
	
	@GetMapping("/courses/{name}")
	public ResponseEntity<List<Course>> getCourseByNameHandler(@PathVariable("name") String name) throws CourseNotFoundException{
			
		List<Course> courseByName= courseService.getCourseByName(name); 
			
		return new ResponseEntity<List<Course>>(courseByName, HttpStatus.CREATED);
	}
	
	// 6. Get Course by Id
	
	@GetMapping("/getcourses/{Id}")
	public ResponseEntity<Course> getCourseByIdHandler(@PathVariable("Id") Integer courseId) throws CourseNotFoundException{
		
		// Added try-catch to check circuit breaker
		try {
			
			Thread.sleep(2000);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		Course getParticularCourse = courseService.getCourseById(courseId);
			
		return new ResponseEntity<Course>(getParticularCourse, HttpStatus.OK);
	}
}
