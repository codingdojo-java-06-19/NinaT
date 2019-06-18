package com.ninatompkin.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.dojooverflow.models.Question;
import com.ninatompkin.dojooverflow.models.Tag;
import com.ninatompkin.dojooverflow.repositories.QuestionRepository;
import com.ninatompkin.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepo;
	private final QuestionRepository questionRepo;
	
	public TagService(TagRepository tagRepo, QuestionRepository questionRepo) {
		this.tagRepo = tagRepo;
		this.questionRepo = questionRepo;
	}
	
	public void addTagToQuestion(String strTag, Question question) {
		Tag tag = tagRepo.findByContent(strTag);
		if (tag == null) {
			tag = new Tag();
			tag.setContent(strTag);
		}	
		addTagToQuestion(tag, question);
	}
	
	//Add a tag to a question??? 
	public void addTagToQuestion(Tag tag, Question question) {
		question.addTag(tag);
		questionRepo.save(question);
	}
	
	//Get all Tags for this Question With Id
	public List<Tag> showTagsForThisQuestion(Long question_id){
		Question thisQuestion = questionRepo.findById(question_id).orElse(null);
		return thisQuestion.getTags();
	}
	
	//Get all Tags for this One Question With Object
	public List<Tag> showTagsForThisQuestion(Question question){
		return question.getTags();
	}
}
