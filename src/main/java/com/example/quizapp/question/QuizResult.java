package com.example.quizapp.question;

import java.util.ArrayList;
import java.util.List;

public class QuizResult {
	public int id;
	public int marks;
	public List<WrongAnswer>wrongAnswers = new ArrayList<>();
	
	
	
	public List<WrongAnswer> getWrongAnswers() {
		return wrongAnswers;
	}
	public void setWrongAnswers(List<WrongAnswer> wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public QuizResult(int id, int marks, List<WrongAnswer> wrongAnswers) {
		super();
		this.id = id;
		this.marks = marks;
		this.wrongAnswers = wrongAnswers;
	}
	public QuizResult() {
		super();
	}
	
	}
