package javaAssignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
 
import java.util.stream.Collectors;

public class task1 {

	public static void main(String[] args) {
		var list = new ArrayList<Integer>();
		 list.add(2);
		 list.add(9);
		 list.add(1);
		 list.add(6);
		 list.add(8);
		 list.add(10);
		 list.add(5);
		 
		 
		 Predicate<Integer>  p = (var t) -> t%2==0;
			 
		 
		 
		var evenList =  list.stream().filter(p).collect(Collectors.toList());
		
		
		 System.out.println(evenList);
		
		
		 
	}

	
}
