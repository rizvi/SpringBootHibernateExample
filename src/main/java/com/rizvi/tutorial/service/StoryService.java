package com.rizvi.tutorial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rizvi.tutorial.dao.StoryDao;
import com.rizvi.tutorial.model.Story;


@Service("storyService")
public class StoryService {

	@Autowired
	StoryDao storyDao;

	@Transactional
	public List<Story> getAllStories() {
		return storyDao.getAllStories();
	}

	@Transactional
	public Story getStory(int id) {
		return storyDao.getStory(id);
	}

	@Transactional
	public void addStory(Story story) {
		storyDao.addStory(story);
	}

	@Transactional
	public void updateStory(Story story) {
		storyDao.updateStory(story);

	}

	@Transactional
	public void deleteStory(int id) {
		storyDao.deleteStory(id);
	}
}
