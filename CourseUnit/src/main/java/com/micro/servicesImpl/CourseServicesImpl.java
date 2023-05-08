package com.micro.servicesImpl;

import java.util.List;
import java.util.Optional;

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
		
		List<Course> allCourses= dao.findAll();
		
		if(allCourses.isEmpty()) {
			
			throw new CourseNotFoundException("Unable to get all courses details.");
			
		}else {
			
			return allCourses;
		}
	}

	@Override
	public Course updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Course> opt= dao.findById(course.getCourseId());
		
		if(opt.isPresent()) {
			
			//this save method perform 2 operation 1. insert 2 merge
			
			Course updatedCourse = dao.save(course);
			
			return updatedCourse;
			
		}else {
			
			throw new CourseNotFoundException("Unable to update given course details");
		}
	}

	@Override
	public Course getCourseById(Integer courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		return dao.findById(courseId)
				.orElseThrow(()-> new CourseNotFoundException("Unable to get course details with given Id "+ courseId));
	}

	@Override
	public Course deleteCourseById(Integer courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Course> opt = dao.findById(courseId);
		
		if(opt.isPresent()) {
			
			Course existingCourse = opt.get();
			
			dao.delete(existingCourse);
			
			return existingCourse;
			
		}else {
			
			throw new CourseNotFoundException("Unable to delete course details with given Id "+ courseId);
		}
	}

	@Override
	public List<Course> getCourseByName(String name) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
