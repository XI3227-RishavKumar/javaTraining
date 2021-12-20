package com.rishavApp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishavApp.demo.entity.Course;
import com.rishavApp.demo.service.courseService;

@RestController
@RequestMapping("/api")
public class courseController {
	
	
//	request->controller->service->repository(entity)
	
	@Autowired
	courseService courseSe;
	
	

	// localhost:5000/api/course
	
	
	@PostMapping("/course")
	public String addCourse(@RequestBody Course course) {
		String message = courseSe.addCourse(course);
		 return message;
	}
	@GetMapping("/course")
	public List<Course> getCourse() {
		 List<Course> allCourse = courseSe.getAllCourse();
		 return allCourse;		 
	}
	
	@GetMapping("/course/{id}")
	public Course getSinglCourse(@PathVariable("id") int courseId) {
		Course SingleCourse = courseSe.getSinglCourse(courseId);
		return SingleCourse;
	}
	
	
	@PutMapping("course/{id}")
	public String updateCourse(@RequestBody Course course, @PathVariable("id") int id) {
		String message = courseSe.updateCourse(course,id);
		return message;
	}
	
	@DeleteMapping("course/{id}")
	public String deleteCourse(@PathVariable("id" )int id) {
		String message = courseSe.deleteCourse(id);
		return message;
	}
	

}
