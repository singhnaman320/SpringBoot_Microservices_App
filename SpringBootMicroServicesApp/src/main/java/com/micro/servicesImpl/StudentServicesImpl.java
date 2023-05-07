package com.micro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entities.Student;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.repositories.StudentJpaDao;
import com.micro.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices{
	
	@Autowired
	private StudentJpaDao dao;

	@Override
	public Student registerStudent(Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		boolean flag= true;
		
		if(flag) {
			
			Student saveStudent= dao.save(student);
			
			return saveStudent;
			
		}else {
			
			throw new StudentNotFoundException("Unable to register student");
		}

	}

	@Override
	public List<Student> getAllStudents() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		List<Student> allStudents= dao.findAll();
		
		if(allStudents.isEmpty()) {
			
			throw new StudentNotFoundException("Unable to get all students details.");
			
		}else {
			
			return allStudents;
		}
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
