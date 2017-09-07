package com.rizvi.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rizvi.tutorial.model.Story;
import com.rizvi.tutorial.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	StoryService storyService;

	@RequestMapping(value = "/getAllStories", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllStories(Model model) {

		List<Story> listOfStories = storyService.getAllStories();
		model.addAttribute("story", new Story());
		model.addAttribute("listOfStories", listOfStories);
		return "storyDetails";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllStories";
	}
	
	@RequestMapping(value = "/getStory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Story getStoryById(@PathVariable int id) {
		return storyService.getStory(id);
	}

	@RequestMapping(value = "/addStory", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addStory(@ModelAttribute("story") Story story) {	
		if(story.getId()==0)
		{
			storyService.addStory(story);
		}
		else
		{	
			storyService.updateStory(story);
		}

		return "redirect:/getAllStories";
	}

	@RequestMapping(value = "/updateStory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateStory(@PathVariable("id") int id,Model model) {
		model.addAttribute("story", this.storyService.getStory(id));
		model.addAttribute("listOfStories", this.storyService.getAllStories());
		return "storyDetails";
	}

	@RequestMapping(value = "/deleteStory/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteStory(@PathVariable("id") int id) {
		storyService.deleteStory(id);
		return "redirect:/getAllStories";

	}	
}
