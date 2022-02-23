package com.udemy.mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class FirstMockito {

	@Test
	public void test() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void test2() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test(expected=RuntimeException.class)
	public void letsmockListGet() {
		List listMock=mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("something"));
		 listMock.get(0);
		
		
	}

}
