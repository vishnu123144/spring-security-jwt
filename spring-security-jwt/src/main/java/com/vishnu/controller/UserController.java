package com.vishnu.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.model.User;
import com.vishnu.model.UserRequest;
import com.vishnu.model.UserResponse;
import com.vishnu.service.IUserService;
import com.vishnu.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
    
	@Autowired
	private IUserService service;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//1. save user data in database
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer id=service.saveUser(user);
		String body="User  '"+id+"' saved";
//		return new ResponseEntity<String>(body,HttpStatus.OK);
		return  ResponseEntity.ok(body);
	}
	
	//2. Validate user and generate token(login)
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(
			@RequestBody UserRequest request){
	  //TODO : validate un/pw with database
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword()));
	String token=util.generateToken(request.getUsername());
	return ResponseEntity.ok(new UserResponse(token,"Success! Generate by Vishnu"));
	}
	
	//3.after login only
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal p){
		return ResponseEntity.ok("Hello User!"+p.getName());
	}
}
