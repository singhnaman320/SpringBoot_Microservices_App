package com.micro.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.entities.Student;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices{

	@Override
	public Student registerStudent(Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
