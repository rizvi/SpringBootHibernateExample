package com.rizvi.tutorial.dao;

import java.util.List;

import com.rizvi.tutorial.model.Story;

public interface StoryDao {
	public List<Story> getAllStories() ;

	public Story getStory(int id) ;

	public Story addStory(Story story);

	public void updateStory(Story story) ;

	public void deleteStory(int id) ;
}
