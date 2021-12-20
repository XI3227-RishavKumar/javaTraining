package com.rishavApp.demo.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishavApp.demo.entity.Course;

 

@Repository
public interface courseRepository extends JpaRepository<Course,Integer> {

}
