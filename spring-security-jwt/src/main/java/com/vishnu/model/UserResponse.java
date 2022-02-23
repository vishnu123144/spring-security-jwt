package com.vishnu.model;

import lombok.Data;


@Data
public class UserResponse {

	
	private String token;
	private String password;
	
	public UserResponse() {
		
	}
	
	public UserResponse(String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
