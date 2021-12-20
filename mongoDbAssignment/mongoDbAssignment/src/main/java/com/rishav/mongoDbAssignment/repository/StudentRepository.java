package com.rishav.mongoDbAssignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rishav.mongoDbAssignment.entity.Student;

public interface StudentRepository extends MongoRepository<Student,Integer> {

	
	@Query(value = "{name: ?0}",count = true)
	Integer getStudentCountByName(String name);
	
	

}
