package com.example.quizapp.service;

import java.util.List;

import com.example.quizapp.question.QuestionWrapper;
import com.example.quizapp.question.QuizResult;
import com.example.quizapp.question.Response;

public interface QuizService {

	public void createQuiz(String category, int numQ, String title);

	public List<QuestionWrapper> getQuizQuestion(int id);

	public QuizResult submitQuiz(Integer id,int userId, List<Response> response);
//	public int submitQuiz(Integer id, List<Response> response);

}
