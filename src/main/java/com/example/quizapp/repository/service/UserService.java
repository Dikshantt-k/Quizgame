package com.example.quizapp.repository.service;

import java.util.List;

import com.example.quizapp.question.User;

public interface UserService {

	public User saveUser(User user);

	public void deleteUserById(int id);

	public List<User> getAllUser();

}
