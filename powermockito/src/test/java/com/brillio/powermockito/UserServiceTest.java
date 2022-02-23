package com.brillio.powermockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class UserServiceTest {
    
	@Test
	public void testGetNameByUserId() {
	
	     UserDao mockDao=PowerMockito.mock(UserDao.class);  //creating a mock object
	
	     PowerMockito.when(mockDao.findNameById(101)).thenReturn("Nick");//defining the behaviour
	     PowerMockito.when(mockDao.findNameById(102)).thenReturn("Ram");
	     UserService service=new UserService(mockDao);
	     String name=service.getNameByUserId(101);
	     String name2=service.getNameByUserId(102);
	     assertEquals("Nick", name);
	     assertEquals("Ram", name2);
	     
	     
	    
	}
	
	@Test
	public void testGetEmailByUserId() {
		 UserDao mockDao2=PowerMockito.mock(UserDao.class);
	     PowerMockito.when(mockDao2.findEmailById(101)).thenReturn("v1@gmail.com");
	     UserService service2=new UserService(mockDao2);
	     String email=service2.getEmailByUserId(101);
	     assertEquals("v1@gmail.com", email);
	}
}
