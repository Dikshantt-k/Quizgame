package com.example.quizapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.question.User;
import com.example.quizapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		
	}
	
	//sort user by their marks, highest scorer become 1st and so on
	//bubble sort
	@Override
	public List<User> getAllUser() {
		
		List<User> users = userRepository.findAll();
		
		for(int turn =0; turn<users.size()-1; turn++) {
			for(int j=0; j<users.size()-1-turn; j++) {
				if(users.get(j).getMarks() < users.get(j + 1).getMarks()) {
				
					User temp = users.get(j);
				users.set(j, users.get(j+1));
				users.set(j+1, temp);
					
				}
			}
		}
		
		
		return users;
	}
	

}
