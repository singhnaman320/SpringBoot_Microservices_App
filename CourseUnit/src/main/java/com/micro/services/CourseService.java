package com.micro.services;

import java.util.List;

import com.micro.entities.Course;
import com.micro.exceptions.CourseNotFoundException;

public interface CourseService {

	public Course registerCourse(Course course)throws CourseNotFoundException;
	
	public List<Course> getAllCourses()throws CourseNotFoundException;
	
	public Course updateCourse(Course course)throws CourseNotFoundException;
	
	public Course getCourseById(Integer courseId)throws CourseNotFoundException;
	
	public Course deleteCourseById(Integer courseId)throws CourseNotFoundException;
	
	public List<Course> getCourseByName(String name)throws CourseNotFoundException;
}
