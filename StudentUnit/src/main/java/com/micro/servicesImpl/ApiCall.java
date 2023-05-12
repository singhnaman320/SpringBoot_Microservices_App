package com.micro.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.entities.Course;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ApiCall {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String courseMicroserviceBaseURL = "http://course-service";
	
	// When course microservice is not sending response or being delayed then fallback method will be called
	@CircuitBreaker(name = "circuitBreaker", fallbackMethod = "fallback")
	public Course getCourseDetails(Integer courseId) {
		
		Course course = restTemplate.getForObject(courseMicroserviceBaseURL + "/courseDetails/getcourses/{courseId}", 
				Course.class, courseId);
		
		return course;
	}
}
