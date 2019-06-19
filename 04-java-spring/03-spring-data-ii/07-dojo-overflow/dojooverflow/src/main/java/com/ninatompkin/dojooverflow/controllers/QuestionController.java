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
	public String postQuestion(@RequestParam("tagStrings") String tags, @ModelAttribute("question") Question question, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors: "+result);
			return "questions/new.jsp";
		}
		else {
		//Create a new question object and populate it with the content we've received via form
		
		//Since we're receiving a string of tags from the form, we need to separate the string into words separated by commas
		String[] commaSeparatedTags = tags.split(",");
		
		//Now we can loop through the array of words...
		for (int i =0; i<commaSeparatedTags.length; i++) {
			
			//But before we add the tag to our DB, we have to check if not it's already in there
			//So if we look in our DB and find that the contents are not in there...
			Tag newTag = tagService.findOrCreateTag(commaSeparatedTags[i]);
			tagService.addTagToQuestion(newTag, question);
		}
		System.out.println("Successfully adding a question! Our question is"+question);
		
		//Finally, we save the question and redirect to the dashboard
		questionService.createOrUpdateQuestion(question);
		return "redirect:/questions/dashboard";
		}
	}
	
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long question_id, Model model, @ModelAttribute("answer") Answer answer) {
		//To render the page, we first must fetch the question we've selected from our DB...
		Question thisQuestion = questionService.showOne(question_id);
		
		//However, if there isn't a question with that id...then we need to redirect back to the dashboard
		if(thisQuestion==null) {
			return "redirect:/questions/dashboard";
		}
		//Otherwise, we found a matching question, so we'll add it to our model so it can be rendered in our JSP.
		model.addAttribute("question", thisQuestion);
		//We also need to find all of the answers associated with this question...
		List<Answer> thisQuestionsAnswers = thisQuestion.getAnswers();
		//..and add them to our model.
		model.addAttribute("answers", thisQuestionsAnswers);
		System.out.println("this questions ansers are..."+thisQuestionsAnswers);
		//Same thing with our Tags
		List<Tag> thisQuestionsTags = thisQuestion.getTags();
		model.addAttribute("tags", thisQuestionsTags);
		return "questions/show.jsp";
	}
	
	@RequestMapping(value="/answer", method=RequestMethod.POST)
	public String addAnswerToQuestion(@ModelAttribute("answer") Answer answer, BindingResult result, @RequestParam("question_id") Long question_id, @RequestParam("content") String answerContent) {
		if(result.hasErrors()) {
			System.out.println("Errors: "+result);
			return "redirect:/questions/"+question_id;
		}
		//Grab the question we need to update from the id passed in via the hidden input
		Question thisQuestion = questionService.showOne(question_id);
		
		//Use the parameters submitted through our form to populate a new Answer with content...
		answer.setContent(answerContent);
		answer.setQuestion(thisQuestion);
		
		System.out.println("Our answer contains the following content: "+answer.getContent());
		answerService.addAnswerToquestion(question_id, answer);
		//...then save that answer.
		answerService.saveAnswer(answer);
		
		//Finally, add the answer to our question using the id we passed via our form parameters...
		
		System.out.println("Our question has the following answers: "+thisQuestion.getAnswers());
		//...and then save the question and refresh the page so we can see the answer added.
		questionService.createOrUpdateQuestion(thisQuestion);
		
		return "redirect:/questions/"+question_id;
	}
}
