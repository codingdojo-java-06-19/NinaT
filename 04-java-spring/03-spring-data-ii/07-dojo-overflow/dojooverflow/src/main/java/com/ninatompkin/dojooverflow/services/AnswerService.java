package com.ninatompkin.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.dojooverflow.models.Answer;
import com.ninatompkin.dojooverflow.models.Question;
import com.ninatompkin.dojooverflow.repositories.AnswerRepository;
import com.ninatompkin.dojooverflow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	private final QuestionRepository questionRepo;
	
	public AnswerService(AnswerRepository answerRepo, QuestionRepository questionRepo) {
		this.answerRepo=answerRepo;
		this.questionRepo=questionRepo;
	}
	
	//Find one question (for use within the service file only)
	public Question findOne(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public void saveAnswer(Answer answer) {
		answerRepo.save(answer);
	}
	
	//Add Answer To Question with Question ID
	public void addAnswerToquestion(Long question_id, Answer answer) {
		Question thisQuestion = findOne(question_id);
		addAnswerToQuestion(thisQuestion, answer);
	}
	
	//Add Answer To Question With Question Object
	public void addAnswerToQuestion(Question question, Answer answer) {
		question.addAnswer(answer);
		questionRepo.save(question);
	}
	
	//Retrieve all Answers for One Question with Question Id
	public List<Answer> answersForThisQuestion(Long question_id){
		Question thisQuestion = findOne(question_id);
		return thisQuestion.getAnswers();
	}
	
	//Retrieve all Answers for One Question with Question Object
	public List<Answer> answersForThisQuestion(Question question){
		return question.getAnswers();
	}
}
