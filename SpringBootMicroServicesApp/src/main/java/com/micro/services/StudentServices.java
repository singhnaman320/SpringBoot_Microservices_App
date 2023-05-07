package com.micro.services;

import java.util.List;

import com.micro.entities.Student;
import com.micro.exceptions.StudentNotFoundException;

public interface StudentServices {

	public Student registerStudent(Student student)throws StudentNotFoundException;
	
	public List<Student> getAllStudents()throws StudentNotFoundException;
	
	public Student updateStudent(Student student)throws StudentNotFoundException;
	
	public Student deleteStudentByRoll(Integer roll)throws StudentNotFoundException;
	
	public List<Student> getStudentByName(String name)throws StudentNotFoundException;
}
