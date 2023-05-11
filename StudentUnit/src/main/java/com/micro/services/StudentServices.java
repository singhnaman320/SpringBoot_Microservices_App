package com.micro.services;

import java.util.List;

import com.micro.entities.Student;
import com.micro.entities.StudentDetails;
import com.micro.exceptions.StudentNotFoundException;

public interface StudentServices {

	public Student registerStudent(Student student)throws StudentNotFoundException;
	
	public List<Student> getAllStudents()throws StudentNotFoundException;
	
	public Student updateStudent(Student student)throws StudentNotFoundException;
	
	public StudentDetails getStudentById(Integer studentId)throws StudentNotFoundException;
	
	public Student deleteStudentById(Integer studentId)throws StudentNotFoundException;
	
	public List<Student> getStudentByName(String name)throws StudentNotFoundException;
	
	public StudentDetails getByIdUsingWebClient(Integer studentId)throws StudentNotFoundException;
}
