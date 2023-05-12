package com.micro.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.entities.Course;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {

	private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String courseMicroserviceBaseURL = "http://course-service";
	
	// When course microservice is not sending response or being delayed then fallback method displayed below will be called 
	@CircuitBreaker(name = "circuitBreaker", fallbackMethod = "fallback")
	public Course getCourseDetails(Integer courseId) {
		
		logger.info("calling course microservice API using RestTemplate");
		
		Course course = restTemplate.getForObject(courseMicroserviceBaseURL + "/courseDetails/getcourses/{courseId}", 
				Course.class, courseId);
		
		return course;
	}
	
	public Course fallback(Exception exception) {
		
		logger.info("calling fallback and returning default course data");
		
		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("common-course");
		course.setCourseDuration(1);
		
		return course;
		
	}
}
