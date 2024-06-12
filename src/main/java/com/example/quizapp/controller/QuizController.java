package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.question.QuestionWrapper;
import com.example.quizapp.question.QuizResult;
import com.example.quizapp.question.Response;
import com.example.quizapp.repository.service.QuizService;
@RequestMapping("/quiz")
@RestController
public class QuizController {
	
	@Autowired
	public QuizService quizService;
	
	@PostMapping("/create")
	//create quiz with "numQ" no of question
	//quiz/create?category=java&numQ=10,&title=quiz
	public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		quizService.createQuiz(category,numQ,title); 
		return new ResponseEntity<>("Quiz Created !!",HttpStatus.OK);
	}
	
	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
		List<QuestionWrapper> qw = quizService.getQuizQuestion(id);
		return new ResponseEntity<>(qw,HttpStatus.OK);
	}
	@PostMapping("/submit/{id}/{userId}")
	public ResponseEntity<QuizResult> submitQuiz(@PathVariable int id,@PathVariable int userId, @RequestBody List<Response> response){
		QuizResult quizResult = quizService.submitQuiz(id,userId,response);
		return new ResponseEntity<>(quizResult,HttpStatus.OK);
	}	

} 
