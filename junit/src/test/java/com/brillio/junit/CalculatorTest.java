package com.brillio.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
	
	static Calculator calculator;
	
	@BeforeClass  //executed before all test methods
	public static void init() { //database initialization
		calculator=new Calculator();
		System.out.println("Executed before all the test method"+calculator);
	}
	
	@AfterClass
	public static void tearDown() {
		calculator=null;
		System.out.println("execute after all the test cases"+calculator);
		
	}
	
	@Before
	public void setup() {
		System.out.println("executed before each test method ->@Before");
	}
     
	@After
	public void setDown() {
		System.out.println("executed after each test method ->@After");
	}
	@Test
	public void TestForValidNaturalAddition() {
		//test case fail
		System.out.println("Test1");
		 calculator=new Calculator();
		int sum=calculator.addition(10, 10);
		
		//static assert method
		assertEquals(20,sum);		
	}
	
	@Test
	public void TestForInvalidNaturalAddition() {
		System.out.println("Test2");
		calculator=new Calculator();
		
		assertEquals(-1, calculator.addition(-10, 2));
		assertEquals(-1, calculator.addition(2, -10));
		assertEquals(-1, calculator.addition(0, 0));
		assertEquals(-1, calculator.addition(10, -2));
		
	}
	
	@Test
	@Ignore
	public void TestForSubstraction() {
		Calculator cal=new Calculator();
		int sub=cal.substraction(20, 30);
		assertEquals(-10,sub);
	}
}
