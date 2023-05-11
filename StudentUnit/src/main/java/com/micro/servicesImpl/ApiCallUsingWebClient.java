package com.micro.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.micro.entities.Course;

import reactor.core.publisher.Mono;

@Service
public class ApiCallUsingWebClient {

	private static final Logger logger = LoggerFactory.getLogger(ApiCallUsingWebClient.class);
	
	private final WebClient.Builder loadBalancedWebClientBuilder;

	private static final String courseMisroserviceBaseURL = 
				"http://course-service";
	  
	public ApiCallUsingWebClient(WebClient.Builder webClientBuilder, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		
	    this.loadBalancedWebClientBuilder = webClientBuilder;
	}

	public Mono<Course> getCourseDetails(int courseId) {
		
		logger.info("calling course microservice API using Web-Client");
			
	    return loadBalancedWebClientBuilder.build().get().uri(courseMisroserviceBaseURL + "/courseDetails/getcourses/" + courseId)
	    		.retrieve().bodyToMono(Course.class);
	}
	
}
