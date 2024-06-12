package com.example.quizapp.question;

public class WrongAnswer {
	
	public String question;
	public String rightAnswer;
	
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getRightgAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public WrongAnswer(String question, String rightAnswer) {
		super();
		this.question = question;
		this.rightAnswer = rightAnswer;
	}
	public WrongAnswer() {
		super();
	}
	
}
