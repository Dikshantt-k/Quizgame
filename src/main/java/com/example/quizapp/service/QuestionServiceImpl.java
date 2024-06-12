package com.example.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.question.Question;
import com.example.quizapp.repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	public QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public void deleteQuestionById(int id) {
		questionRepository.deleteById(id);
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		return questionRepository.findByCategory(category);
	}

}
