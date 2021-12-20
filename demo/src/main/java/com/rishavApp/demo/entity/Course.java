package com.rishavApp.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
	
	
	@Id
	@GeneratedValue
	private int course_id;
	private String course_name;
 

}
