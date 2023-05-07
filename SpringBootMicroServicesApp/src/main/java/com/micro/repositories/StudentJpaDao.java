package com.micro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.entities.Student;

@Repository
public interface StudentJpaDao extends JpaRepository<Student, Integer>{

}
