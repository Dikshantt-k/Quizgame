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

import com.example.quizapp.question.Question;
import com.example.quizapp.service.QuestionService;


@RestController
@RequestMapping("/question")

	
public class QuestionController {
	
	@Autowired
	public QuestionService questionService;
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Question>addQuestion(@RequestBody Question question ){
		Question saveQuestion = questionService.addQuestion(question);
		return new ResponseEntity<>(saveQuestion,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<String>deleteQuestionById(@PathVariable int id){
		questionService.deleteQuestionById(id);
		return  ResponseEntity.ok("QUestion delete successfully");
	}
	
	@GetMapping("/getByCategory/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category  ){
	List<Question> questionByCategory = questionService.getQuestionByCategory(category);
		return new ResponseEntity<>(questionByCategory,HttpStatus.OK);
	}
	
}
