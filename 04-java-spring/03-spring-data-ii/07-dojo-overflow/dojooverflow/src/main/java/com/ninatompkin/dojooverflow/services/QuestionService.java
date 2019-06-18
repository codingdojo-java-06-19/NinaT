package com.ninatompkin.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.dojooverflow.models.Question;
import com.ninatompkin.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	//Create a question
	public Question createOrUpdateQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	//Find all questions
	public List<Question> showAllQuestions(){
		return questionRepo.findAll();
	}
	
	//Show one question 
	public Question showOne(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
}
