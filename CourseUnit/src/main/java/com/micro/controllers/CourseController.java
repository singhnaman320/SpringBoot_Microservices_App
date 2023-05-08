package com.micro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.micro.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
}
