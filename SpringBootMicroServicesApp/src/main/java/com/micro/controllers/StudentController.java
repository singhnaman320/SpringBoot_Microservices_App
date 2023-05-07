package com.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entities.Student;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.services.StudentServices;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentServices studentService;
	
	// 1. Registering Students
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@Valid @RequestBody Student student) throws StudentNotFoundException{
		
		Student registerStudent = studentService.registerStudent(student);
		
		return new ResponseEntity<Student>(registerStudent, HttpStatus.CREATED);
		
	}
	
	// 2. Getting all the Students
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler() throws StudentNotFoundException{
		
		List<Student> gettingList= studentService.getAllStudents();
		
		return new ResponseEntity<List<Student>>(gettingList, HttpStatus.OK);
	}
	
	
	
}
