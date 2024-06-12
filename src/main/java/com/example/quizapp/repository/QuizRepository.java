package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.question.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
