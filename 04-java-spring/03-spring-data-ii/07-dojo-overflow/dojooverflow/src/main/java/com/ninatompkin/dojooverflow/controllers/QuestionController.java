package com.ninatompkin.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ninatompkin.dojooverflow.models.Answer;
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
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "questions/new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	//We can't use @ModelAttribute because we need to hand build the Question object ourselves with the parameters given
	public String postQuestion(@RequestParam("content") String content, @RequestParam("tags") String tags, @ModelAttribute("question") Question question, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors: "+result);
			return "questions/new.jsp";
		}
		else {
		//Create a new question object and populate it with the content we've received via form
		Question newQuestion = new Question();
		newQuestion.setContent(content);
		
		//Since we're receiving a string of tags from the form, we need to separate the string into words separated by commas
		String[] commaSeparatedTags = tags.split(",");
		
		//Now we can loop through the array of words...
		for (int i =0; i<commaSeparatedTags.length; i++) {
			
			//But before we add the tag to our DB, we have to check if not it's already in there
			//So if we look in our DB and find that the contents are not in there...
			if(tagService.checkForTagInDB(commaSeparatedTags[i])==null){
				//Then we've got ourselves a new tag, baby!
				Tag newTag = new Tag();
				//Use the form content to set the content of the tag...
				newTag.setContent(commaSeparatedTags[i]);
				//Save the new tag!
				tagService.saveTag(newTag);
				//Add the new Tag to our Question
				tagService.addTagToQuestion(newTag, newQuestion);
			}
			else {
				//If it's already in our system, we won't add it to our DB, but we'll add it to the question.
				//First, we'll use the content to figure out which tag it is...
				Tag existingTag = tagService.checkForTagInDB(commaSeparatedTags[i]);
				//...and then we'll add it to our Question
				tagService.addTagToQuestion(existingTag, newQuestion);
			}
		}
		System.out.println("Successfully adding a question! Our question is"+newQuestion);
		
		//Finally, we save the question and redirect to the dashboard
		questionService.createOrUpdateQuestion(newQuestion);
		return "redirect:/questions/dashboard";
		}
	}
	
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long question_id, Model model, @ModelAttribute("answer") Answer answer) {
		//To render the page, we first must fetch the question we've selected from our DB...
		Question thisQuestion = questionService.showOne(question_id);
		//...and add it to our model so it can be rendered in our JSP.
		model.addAttribute("question", thisQuestion);
		//We also need to find all of the answers associated with this question...
		List<Answer> thisQuestionsAnswers = thisQuestion.getAnswers();
		//..and add them to our model.
		model.addAttribute("answers", thisQuestionsAnswers);
		
		return "questions/show.jsp";
	}
	
	@RequestMapping("/answer")
	public String addAnswerToQuestion(Model model, @RequestParam("question_id") Long question_id, @RequestParam("content") String answerContent) {
		
		//Use the parameters submitted through our form to populate a new Answer with content...
		Answer newAnswer = new Answer();
		newAnswer.setContent(answerContent);
		//...then save that answer.
		answerService.saveAnswer(newAnswer);
		//Finally, add the answer to our question using the id we passed via our form parameters...
		answerService.addAnswerToquestion(question_id, newAnswer);
		
		//...and then save the question and referesh the page so we can see the answer added.
		Question thisQuestion = questionService.showOne(question_id);
		questionService.createOrUpdateQuestion(thisQuestion);
		
		return "redirect:/questions/"+question_id;
	}
}
