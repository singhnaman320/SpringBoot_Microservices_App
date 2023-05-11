package com.micro.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.entities.Course;
import com.micro.entities.Student;
import com.micro.entities.StudentDetails;
import com.micro.exceptions.StudentNotFoundException;
import com.micro.repositories.StudentJpaDao;
import com.micro.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices{
	
	@Autowired
	private StudentJpaDao dao;
	
	@Autowired 
	private ApiCall apiCall;   // using restTemplate
	
	@Autowired 
	private ApiCallUsingWebClient apiCallUsingWebClient; // using webClient

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
		
		List<Student> studentList= dao.findAll().stream().filter(s->Objects.equals(s.getName(), name)).collect(Collectors.toList());
		
		if(studentList.size() !=0) {
			
			return studentList;

		}else {
			
			throw new StudentNotFoundException("Unable to get student details by his/her name");

		}
	}

	@Override
	public StudentDetails getStudentById(Integer studentId) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		// getting student from table by passing id
				Student student = dao.findById(studentId).orElseThrow(()->new StudentNotFoundException("Unable to delete student details with given Id "+ studentId));
				
				//getting course from course microservice by call API
				Course course = apiCall.getCourseDetails(student.getCourseId());
				
				StudentDetails studentDetails = new StudentDetails();
				BeanUtils.copyProperties(student, studentDetails); // It copy the properties from one object to another object
				studentDetails.setCourse(course);  // setting the course got from api call above
				return studentDetails;
		
	}

	@Override
	public StudentDetails getByIdUsingWebClient(Integer Id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
