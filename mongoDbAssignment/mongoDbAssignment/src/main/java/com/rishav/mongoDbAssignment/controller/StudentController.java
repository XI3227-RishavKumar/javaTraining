package com.rishav.mongoDbAssignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.mongoDbAssignment.entity.Student;
import com.rishav.mongoDbAssignment.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/mongoDbApi")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		String message = studentservice.addStudent(student);
		return message;
	}

	
	@GetMapping("/student")
	public List<Student> getAllStudent() {
		List<Student> studentList = studentservice.getAllStudent();
		return studentList ;
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getSinglStudent(@PathVariable("id") int studentId) {
		Student SingleStudent = studentservice.getSinglStudent(studentId);
		 if(SingleStudent!=null) {
			 return ResponseEntity.status(HttpStatus.OK).body(SingleStudent);
		 }
		 else {
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(SingleStudent);
		 }
	}
	
	@PutMapping("student/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		String message = studentservice.updateStudent(student,id);
		return message;
	}
	
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable("id" )int id) {
		String message = studentservice.deleteStudent(id);
		return message;
	}
	
	@GetMapping("student/countBy/Name/{name}")
	public int getStudentCountByName(@PathVariable String name) {
		int count = studentservice.getStudentCountByName(name); 
		return count;
	}
	

}
