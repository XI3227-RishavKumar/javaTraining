package com.rishav.mongoDbAssignment.entity;

 import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "student")
public class Student {
  
	@Id
	private int id;
	private String name;
	private int marks;
	
	
	
}
