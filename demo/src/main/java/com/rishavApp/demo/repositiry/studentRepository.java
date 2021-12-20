package com.rishavApp.demo.repositiry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rishavApp.demo.entity.Student;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {

	Optional<Student> findByName(String studentName);

	@Query(value ="select count(*) from student", nativeQuery = true)
	int countStudent();

	 
  
 
}
