package com.micro.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.entities.Student;
import com.micro.entities.StudentDetails;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.services.StudentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/studentDetails")
@RefreshScope
public class StudentController {

	@Autowired
	private StudentServices studentService;
	
	// For Illustration purpose of config server
	@Value("${message:default message}")
	private String message;
	
	@GetMapping("/message")
	public ResponseEntity<String> getMessage(){
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
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
	
	// 3. Updating Student details
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@Valid @RequestBody Student student) throws StudentNotFoundException{
		
		Student updateStudentDetails = studentService.updateStudent(student);
		
		return new ResponseEntity<Student>(updateStudentDetails, HttpStatus.ACCEPTED);
	}
	
	// 4. Delete Student by its Id
	
	@DeleteMapping("/students/{Id}")
	public ResponseEntity<Student> deleteStudentByIdHandler(@PathVariable("Id") Integer studentId) throws StudentNotFoundException{
		
		Student deleteStudent = studentService.deleteStudentById(studentId);
		
		return  new ResponseEntity<Student>(deleteStudent, HttpStatus.ACCEPTED);
	}
	
	
	// 5. Get Students by its name
	
	@GetMapping("/students/{name}")
	public ResponseEntity<List<Student>> getStudentByNameHandler(@PathVariable("name") String name) throws StudentNotFoundException{
		
		List<Student> studentByName= studentService.getStudentByName(name); 
		
		return new ResponseEntity<List<Student>>(studentByName, HttpStatus.CREATED);
	}
	
	// 6. Get student by Id
	// For Rest Template
	
	@GetMapping("/getstudents/{Id}")
	public ResponseEntity<StudentDetails> getStudentByIdHandler(@PathVariable("Id") Integer studentId) throws StudentNotFoundException{
		
		StudentDetails getParticularStudent = studentService.getStudentById(studentId);
		
		return new ResponseEntity<StudentDetails>(getParticularStudent, HttpStatus.OK);
	}
	
	// 7. For web client
	
	@GetMapping("/webClient/{Id}")
	public ResponseEntity<StudentDetails> getByIdUsingWebClientHandler(@PathVariable("Id") Integer Id) throws StudentNotFoundException{
		
		logger.info("/webClient/{Id}");
		StudentDetails getParticularStudent = studentService.getByIdUsingWebClient(Id);
		
		return new ResponseEntity<StudentDetails>(getParticularStudent, HttpStatus.OK);
	}
}
