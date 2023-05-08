package com.micro.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.entities.Course;
import com.micro.exceptions.CourseNotFoundException;
import com.micro.services.CourseService;

@Service
public class CourseServicesImpl implements CourseService{

	@Override
	public Course registerCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAllCourses() throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourseById(Integer courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course deleteCourseById(Integer courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourseByName(String name) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
