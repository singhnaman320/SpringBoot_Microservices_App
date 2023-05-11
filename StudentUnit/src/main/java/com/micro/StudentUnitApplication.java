package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class StudentUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentUnitApplication.class, args);
	}

	// Annotating bean for Rest Template
	@Bean
	@LoadBalanced  // It tells that you have to resolve the application name using Eureka Server
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced	// It tells that you have to resolve the application name using Eureka Server
	WebClient.Builder webClientBuilder() {
	  return WebClient.builder();
	}
}
