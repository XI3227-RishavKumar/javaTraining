package com.rishavApp.demo.mathUtil;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


@SpringBootTest
public class MathCalculationTest {
	
	
	
	@Test
	public void doubleAdd() {
		 MathCalculation mathcalculation = new MathCalculation();
		 
		 int result = mathcalculation.doubleAdd(0, 0);
		  assertEquals(0, result);
	 
		    result = mathcalculation.doubleAdd(2, 3);
		  assertEquals(10, result);
		 
		    result = mathcalculation.doubleAdd(-2, -4);
		  assertEquals(-12, result);
		  
		    result = mathcalculation.doubleAdd(9, -3);
		  assertEquals(12, result);
	 }
	
	@Test
	public void  add() {
		 MathCalculation mathcalculation = new MathCalculation();
		 
		 int result = mathcalculation.add(0, 0);
		  assertEquals(0, result);
	 
		    result = mathcalculation.add(2, 3);
		  assertEquals(5, result);
		 
		    result = mathcalculation.add(-2, -4);
		  assertEquals(-6, result);
		  
		    result = mathcalculation.add(9, -3);
		  assertEquals(6, result);
	 }
	
	
 
	
	 
}
