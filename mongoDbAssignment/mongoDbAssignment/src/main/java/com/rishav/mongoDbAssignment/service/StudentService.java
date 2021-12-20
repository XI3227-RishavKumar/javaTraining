package com.rishav.mongoDbAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.rishav.mongoDbAssignment.entity.Student;
import com.rishav.mongoDbAssignment.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private CustomSeqService customseqservice;

	public String addStudent(Student student) {
		int studentid = customseqservice.getNextSeq("studentSeq");
		
		student.setId(studentid);
		
		studentrepository.save(student);
		return "student added successfully";
	}

	public List<Student> getAllStudent() {
		 return studentrepository.findAll();	 
	}

	public Student getSinglStudent(int studentId) {
		 Optional<Student> student = studentrepository.findById(studentId);
		 return student.isPresent()?student.get():null;
	}

	public String updateStudent(Student student, int id) {
	 
		 Optional<Student> updateStudent = studentrepository.findById(id);
		 if(updateStudent.isPresent()) {
			   updateStudent.get().setId(student.getId());
			   updateStudent.get().setName(student.getName());
			   updateStudent.get().setMarks(student.getMarks());
			  
		 
			   studentrepository.save(updateStudent.get());
			   
			 return "student updated successfully";
		 }
		 else {
			 return "Employee not found";
		 }
		 

}

	public String deleteStudent(int id) {
		Optional<Student> deleteStudent = studentrepository.findById(id);
	 if(deleteStudent.isPresent()) {
		 studentrepository.deleteById(id);
		 return "Employee deleted successfully";
	 }
	 else {
		 return "student not found";
	 }
	}

	 

	public int getStudentCountByName(String name) {
		int count = studentrepository.getStudentCountByName(name);
		return count;
	}
}
