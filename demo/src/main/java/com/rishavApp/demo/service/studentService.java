package com.rishavApp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rishavApp.demo.entity.Student;
import com.rishavApp.demo.mathUtil.MathCalculation;
import com.rishavApp.demo.repositiry.studentRepository;


@Service
public class studentService {

	@Autowired
	studentRepository studentRe;
	
	public String addStudent(Student student) {
		
		studentRe.save(student);
		return "Student added success fully";
	}
	
	public List<Student> getAllStudent(int pageNo, int pageSize, String sortOrder){
		
	  Pageable pageable = PageRequest.of(pageNo, pageSize, sortOrder.equals("asc") ? Sort.by("name").ascending():Sort.by("name").descending());
		Page<Student> allStudent = studentRe.findAll(pageable);
		return allStudent.toList();
	}

	public Student getSinglStudent(int studentId) {
		 Optional<Student> student = studentRe.findById(studentId);
		 return student.isPresent()?student.get():null;
	}
	public Student getSinglStudentByName(String studentName) {
		Optional<Student> student = studentRe.findByName(studentName);
		return student.isPresent()?student.get():null;
	}

	public String updateStudent(Student student, int id) {
	 
		 Optional<Student> updateStudent = studentRe.findById(id);
		 if(updateStudent.isPresent()) {
			   updateStudent.get().setId(student.getId());
			   updateStudent.get().setName(student.getName());
			   updateStudent.get().setMarks(student.getMarks());
			   updateStudent.get().setStudent_address(student.getStudent_address());
			   updateStudent.get().setCourse(student.getCourse());
		 
			   studentRe.save(updateStudent.get());
			   
			 return "student updated successfully";
		 }
		 else {
			 return "Employee not found";
		 }
		 
	}

	public String deleteStudent(int id) {
		Optional<Student> deleteStudent = studentRe.findById(id);
	 if(deleteStudent.isPresent()) {
		 studentRe.deleteById(id);
		 return "Employee deleted successfully";
	 }
	 else {
		 return "student not found";
	 }
	}

	public int getStudentCount() {
		return studentRe.countStudent();
	}

	public long getStudentCountByJpa() {
		return studentRe.count();
	}

	public int add(int num1, int num2) {
		MathCalculation mathCalculation = new MathCalculation();
		return mathCalculation.add(num1, num2);
	}

	public int doubleAdd(int num1, int num2) {
		MathCalculation mathCalculation = new MathCalculation();
		 int result = mathCalculation.doubleAdd(num1,num2);
		 
		return result;
	}

 
	
}
