package com.micro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entities.Course;
import com.micro.exceptions.CourseNotFoundException;
import com.micro.repositories.CourseJpaDao;
import com.micro.services.CourseService;

@Service
public class CourseServicesImpl implements CourseService{

	@Autowired
	private CourseJpaDao dao;
	
	@Override
	public Course registerCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		boolean flag= true;
		
		if(flag) {
			
			Course saveCourse= dao.save(course);
			
			return saveCourse;
			
		}else {
			
			throw new CourseNotFoundException("Unable to register course");
		}
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
