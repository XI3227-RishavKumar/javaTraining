package com.rishavApp.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishavApp.demo.entity.Student;
import com.rishavApp.demo.service.studentService;

@RestController
@RequestMapping("/api")
public class studentController {

	
//	request->controller->service->repository(entity)
	
	@Autowired
	studentService studentser;
	
	
	// localhost:5000/api/student
	
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		String message = studentser.addStudent(student);
		 return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	@GetMapping("/student/{pageNo}/{pageSize}/{sortOrder}")
	public List<Student> getStudent(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize,@PathVariable("sortOrder") String sortOrder) {
		 List<Student> allStudent = studentser.getAllStudent(pageNo,pageSize,sortOrder);
		 return allStudent;		 
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getSinglStudent(@PathVariable("id") int studentId) {
		Student SingleStudent = studentser.getSinglStudent(studentId);
		 if(SingleStudent!=null) {
			 return ResponseEntity.status(HttpStatus.OK).body(SingleStudent);
		 }
		 else {
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(SingleStudent);
		 }
	}
	
	@GetMapping("/student/getByName/{name}")
	public ResponseEntity<Student> getSinglStudent(@PathVariable("name") String name) {
		Student SingleStudent = studentser.getSinglStudentByName(name);
		if(SingleStudent!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(SingleStudent);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(SingleStudent);
		}
	}
	
	@GetMapping("/student/count")
	public int getStudentCount() {
		int studentCount = studentser.getStudentCount();
		 return studentCount;
	}
	
	@GetMapping("/student/countByJpa")
	public long getStudentCountByJpa() {
		long studentCount = studentser.getStudentCountByJpa();
		return studentCount;
	}
	
	
	@PutMapping("student/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		String message = studentser.updateStudent(student,id);
		return message;
	}
	
	@DeleteMapping("student/{id}")
	public String deleteStudent(@PathVariable("id" )int id) {
		String message = studentser.deleteStudent(id);
		return message;
	}
	
	@GetMapping("student/{num1}/{num2}")
	public int add(@PathVariable("num1" ) int num1,@PathVariable("num2") int num2) {
		int result = studentser.add(num1,num2);
		return result;
	}
	@GetMapping("student/doubleAdd/{num1}/{num2}")
	public int doubleAdd(@PathVariable("num1" ) int num1,@PathVariable("num2") int num2) {
		int result = studentser.doubleAdd(num1,num2);
		return result;
	}
	
	
	
	
}
