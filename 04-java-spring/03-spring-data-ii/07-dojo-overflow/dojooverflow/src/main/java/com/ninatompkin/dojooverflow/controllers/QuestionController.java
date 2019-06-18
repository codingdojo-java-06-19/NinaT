package com.ninatompkin.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninatompkin.dojooverflow.models.Question;
import com.ninatompkin.dojooverflow.models.Tag;
import com.ninatompkin.dojooverflow.services.AnswerService;
import com.ninatompkin.dojooverflow.services.QuestionService;
import com.ninatompkin.dojooverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}

	@RequestMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Question> questions = questionService.showAllQuestions();
		model.addAttribute("questions", questions);
		return "questions/dashboard.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion() {
		return "questions/new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String postQuestion(@RequestParam("content") String content, @RequestParam("tags") String tags) {
		Question newQuestion = new Question()
		//Since we're receiving a string of tags from the form, we need to separate the string into words separated by commas
		String[] commaSeparatedTags = tags.split(",");
		//Once we have an array of Strings representing individual words, we can loop through them
		for (int i =0; i<commaSeparatedTags.length; i++) {
			//With each tag we go through, we'll add it to the question.
			tagService.addTagToQuestion(commaSeparatedTags[i], question);
			//Do we have to rebuild an array of Tags so that we can set Tags on the question?
		}
		//Finally, we save the question
		System.out.println("Successfully adding a question! Our question is"+question);
		questionService.createOrUpdateQuestion(question);
		return "redirect:/questions/dashboard";
	}
	
	@RequestMapping("/1")
	public String showQuestion() {
		
		return "questions/show.jsp";
	}
}
