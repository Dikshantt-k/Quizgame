package com.example.quizapp.repository.service;

import java.util.List;
import com.example.quizapp.question.Question;


public interface QuestionService {

	public Question addQuestion(Question question);

	public void deleteQuestionById(int id);

	public List<Question> getQuestionByCategory(String category);

}
