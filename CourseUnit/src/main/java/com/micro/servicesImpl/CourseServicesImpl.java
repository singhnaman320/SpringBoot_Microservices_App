 package com.micro.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entities.Course;
import com.micro.exceptions.CourseNotFoundException;
import com.micro.repositories.CourseJpaDao;
import com.micro.services.CourseService;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;

@Service
public class CourseServicesImpl implements CourseService{

	private static final Logger logger = LoggerFactory.getLogger(CourseServicesImpl.class);
	
	@Autowired 
	private Tracer tracer;
	
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
		
		logger.info("logs before custom span");
		// To create the custom span, we have to Autowire the Tracer(Like above) and provide it name like here (custom-log)
		Span newSpan = this.tracer.nextSpan().name("custom-log");
		
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
			
		    // ...
		    // You can tag a span with key value pairs
		    newSpan.tag("custom-tag", "##333##");
		    // ...
		    logger.info("Logs in custom span");
		    
		}
		finally {
			
		    // Once done remember to end the span. This will allow collecting
		    // the span to send it to a distributed tracing system e.g. Zipkin
		    newSpan.end();
		    
		}

		Course course= dao.findById(courseId)
				.orElseThrow(()-> new CourseNotFoundException("Unable to get course details with given Id "+ courseId));
		
		logger.info("logs after custom span");
		return course;
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
		
		List<Course> courseList= dao.findAll()
				.stream()
				.filter(c->Objects.equals(c.getCourseName(), name))
				.collect(Collectors.toList());
		
		if(courseList.size() !=0) {
			
			return courseList;

		}else {
			
			throw new CourseNotFoundException("Unable to get course details by its name");

		}
	}
}
