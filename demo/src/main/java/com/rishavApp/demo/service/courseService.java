package com.rishavApp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishavApp.demo.entity.Course;
import com.rishavApp.demo.entity.Student;
import com.rishavApp.demo.repositiry.courseRepository;

@Service
public class courseService {

	@Autowired
	courseRepository courseRe;

	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		courseRe.save(course);
		return "course added successfully";
	}

	public List<Course> getAllCourse() {
		List<Course> list =  courseRe.findAll();
	   list.forEach(s->s.setCourse_name("LPU_"+s.getCourse_name()));
		return  list;
	}

	public Course getSinglCourse(int courseId) {
		Optional<Course> course = courseRe.findById(courseId);
		 return course.isPresent()?course.get():null;
	}

	public String updateCourse(Course course, int id) {
		 Optional<Course> updateCourse = courseRe.findById(id);
		 if(updateCourse.isPresent()) {
			 updateCourse.get().setCourse_id(course.getCourse_id());;
			 updateCourse.get().setCourse_name(course.getCourse_name());
			   
//			   updateStudent.get().setStudent_address(student.getStudent_address());
		 
			 courseRe.save(updateCourse.get());
			   
			 return "course updated successfully";
		 }
		 else {
			 return "course not found";
		 }
	}

	public String deleteCourse(int id) {
		Optional<Course> deleteCourse = courseRe.findById(id);
		 if(deleteCourse.isPresent()) {
			 courseRe.deleteById(id);
			 return "Course deleted successfully";
		 }
		 else {
			 return "Course not found";
		 }
	}
	
}
