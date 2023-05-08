package com.micro.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
		
		Optional<Student> opt= dao.findById(student.getStudentId());
		
		if(opt.isPresent()) {
			
			//this save method perform 2 operation 1. insert 2 merge
			
			Student updatedStudent = dao.save(student);
			
			return updatedStudent;
			
		}else {
			
			throw new StudentNotFoundException("Unable to update given student details");
		}
	}

	@Override
	public Student deleteStudentById(Integer studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Student> opt = dao.findById(studentId);
		
		if(opt.isPresent()) {
			
			Student existingStudent = opt.get();
			
			dao.delete(existingStudent);
			
			return existingStudent;
			
		}else {
			
			throw new StudentNotFoundException("Unable to delete student details with given Id "+ studentId);
		}
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		List<Student> categoryList= dao.findAll().stream().filter(s->Objects.equals(s.getName(), name)).collect(Collectors.toList());
		
		if(categoryList.size() !=0) {
			
			return categoryList;

		}else {
			
			throw new StudentNotFoundException("Unable to get student details by his/her name");

		}
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		return dao.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Unable to get student details with given Id "+ studentId));
		
	}
	
}
