package com.brillio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CalculatorServiceTest {

	@Mock
	CalculatorService dummyObj;
	
	@Test
	public void testAddition() {
		//creating mock object
//		CalculatorService dummyObj = mock(CalculatorService.class);
	    
		//add behaviour
		when(dummyObj.addition(10, 10)).thenReturn(20);
	    
	    assertEquals(20, dummyObj.addition(10, 10));
	    Mockito.verify(dummyObj, times(1)).addition(10,10);
	}
	
	@Test
	public void testSample() {
		//creating mock object
		ArrayList list = mock(ArrayList.class);
	    
		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
		
		list.add("1");
		list.add("1");
		list.add("2");
		
		Mockito.verify(list,times(2)).add("1");
		Mockito.verify(list,times(1)).add("2");
	}


}
