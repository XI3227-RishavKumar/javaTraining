package com.rishavApp.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rishavApp.demo.entity.Course;
import com.rishavApp.demo.repositiry.courseRepository;

@SpringBootTest

public class CourseServiceTest {

	
	@Mock
	private courseRepository courserepository;
	
	@InjectMocks
	private courseService courseservice;
	
	@Test
	public void testGetAllCourse() {
		
		List<Course> studentList = new ArrayList<>();
		
		studentList.add(new Course(1,"MBA"));
		studentList.add(new Course(2,"IT"));
		studentList.add(new Course(3,"CSE"));
		studentList.add(new Course(4,"CIVIL"));
		 
		
		when(courserepository.findAll()).thenReturn(studentList);
		
		List<Course> actualCourseList = courseservice.getAllCourse();
		 assertEquals(studentList.size(),actualCourseList.size());
	}
	
	
	@Test
	public void testGetSinglCourse() {
		int id = 3;
		Course course = new Course(3,"BTECH");
		
		when(courserepository.findById(id)).thenReturn(Optional.of(course));
		
		 
		 Course actualCourse = courseservice.getSinglCourse(id);
		 
		 assertEquals(course.getCourse_name(),actualCourse.getCourse_name());
		 

		
		
	}
	
	@Test
	public void testAddCourse() {
	 Course course = new Course(1,"BBA");
	 
	 when(courserepository.save(course)).thenReturn(null);
		 
	 String message = "course added successfully";
	 String actualMessage = courseservice.addCourse(course); 
	 
	 assertEquals(message,actualMessage);

		
		
	}
	
	
	@Test
	public void testUpdateCourse() {
		int id = 3;
		int id2 =4;
		Course course = new Course(3,"BTECH");
		
		
		// checking if condition of update function
		when(courserepository.findById(id)).thenReturn(Optional.of(course));
		String message = "course updated successfully";
	    String actualMessage = courseservice.updateCourse(course,id); 
		assertEquals(message,actualMessage);
		 
		 
		//checking else condition of update statement
		 when(courserepository.findById(id2)).thenReturn(Optional.of(course));
		 String mess = "course not found";
		 String actualMess = courseservice.updateCourse(course,5); 
		 assertEquals(mess,actualMess);
		 
}
 
	
	
	@Test
	public void testDeleteCourse() {
		int id = 3;
		int id2 = 1;
		Course course = new Course(3,"BTECH");
		
		// if condition	 
		when(courserepository.findById(id)).thenReturn(Optional.of(course));
		String message = "Course deleted successfully";
	    String actualMessage = courseservice.deleteCourse(id); 
		assertEquals(message,actualMessage);
		 
		 
		// checking else condition
		when(courserepository.findById(id2)).thenReturn(Optional.of(course));
		 String mes = "Course not found";
		 String actualMes = courseservice.deleteCourse(4); 
		 assertEquals(mes,actualMes);
}
	
}
