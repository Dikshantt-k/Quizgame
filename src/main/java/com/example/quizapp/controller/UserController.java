package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.question.User;
import com.example.quizapp.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user ){
		User u=userService.saveUser(user);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id){
		userService.deleteUserById(id);
		return ResponseEntity.ok("User Delete Successfully");
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>>getAllUser(){
		List<User> user= userService.getAllUser();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
