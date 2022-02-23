package com.udemy.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import com.udemy.TodoBusinessImpl;
import com.udemy.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplmockitoTest {
	
	@Mock //creating mock object
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Test
	public void usingMockito() {
		List<String> todos=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		when(todoService.retrieveTodos("Dummy")).thenReturn(todos);
		
//		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoService);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	//given-willReturn
	//when-thenResurn
	@Test
	public void usingMockito2() {
		List<String> todos=Arrays.asList();
		when(todoService.retrieveTodos("Dummy")).thenReturn(todos);
		
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void usingMockito_UsingBDD() {
		
//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {

	

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}



}
