package com.micro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.entities.Course;

@Repository
public interface CourseJpaDao extends JpaRepository<Course, Integer>{

}
