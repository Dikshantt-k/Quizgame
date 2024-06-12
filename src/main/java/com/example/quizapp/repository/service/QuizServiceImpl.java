package com.example.quizapp.repository.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.quizapp.question.Question;
import com.example.quizapp.question.QuestionWrapper;
import com.example.quizapp.question.Quiz;
import com.example.quizapp.question.QuizResult;
import com.example.quizapp.question.Response;
import com.example.quizapp.question.User;
import com.example.quizapp.question.WrongAnswer;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.UserRepository;

@Service
public class QuizServiceImpl implements QuizService{
	
	
	@Autowired
	public QuizRepository quizRepository;
	
	@Autowired
	public QuestionRepository questionRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public void createQuiz(String category, int numQ, String title)
	{
		List<Question> question =questionRepository.findRandomQuestionByCategory(category, numQ);
		
		Quiz quiz =new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(question);
		quizRepository.save(quiz);
	
	}

	@Override
	public List<QuestionWrapper> getQuizQuestion(int id) 
	{
		Optional<Quiz> quiz =quizRepository.findById(id);
		List<Question>questionFromDb = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Question q : questionFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		} 
		return questionForUser;
	}

	// get quiz from quiz question and show to use
	//check weather response are corrects
	//return quiz response and user marks
	@Override
	public QuizResult submitQuiz(Integer id,int userId, List<Response> response) 
	{
		Quiz quiz =quizRepository.findById(id).get();
		List<Question> question = quiz.getQuestion();
		
		int marks = 0 ;
	    
		List<WrongAnswer>wrongAnswer=new ArrayList<>();

	    
	    
	    for (int i = 0; i < response.size(); i++) {
	        if (response.get(i).getResponse().equals(question.get(i).getRightAnswer())) {
	            int sum =question.get(i).getPointValue();
	        	marks= sum +marks;
	        }
	        else 
	        {
	        	 WrongAnswer wa = new WrongAnswer();
	        	 wa.setQuestion(question.get(i).getQuestionTitle());
	        	 wa.setRightAnswer(question.get(i).getRightAnswer());
	        	 wrongAnswer.add(wa);
	        	
	        }
	    }
	    
	    User user = userRepository.findById(userId).get();
	    user.setCategory(question.get(1).getCategory());
	    user.setMarks(marks);
	    userRepository.save(user);	    
	    
	    
	    QuizResult quizResult = new QuizResult();
	    quizResult.setId(quiz.getId());
	    quizResult.setMarks(marks);
	    quizResult.setWrongAnswers(wrongAnswer);
	    
	    return quizResult;

	    
	}
}



//future reference

//int right =0;
//int i=0;
//for (Response response1 : response) {
//	
//	if (response1.getResponse().equals(question.get(i).getRightAnswer()))
//		right++;
//	i++;
//	
//}

//
//@Override
//public int submitQuiz(Integer id, List<Response> response) {
//	Quiz quiz =quizRepository.findById(id).get();
//	List<Question> question = quiz.getQuestion();
//	int marks = 0 ;
//    int right = 0;
//    for (int i = 0; i < response.size(); i++) {
//        if (response.get(i).getResponse().equals(question.get(i).getRightAnswer())) {
//            int sum =question.get(i).getPointValue();
//        	marks= sum +marks;
//        	right ++;
//        }
//        else {
//        	String ra =question.get(i).getRightAnswer();
//        }
//    }
//    return marks;






