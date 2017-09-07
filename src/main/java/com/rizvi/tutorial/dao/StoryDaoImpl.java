package com.rizvi.tutorial.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rizvi.tutorial.model.Story;

@Repository
public class StoryDaoImpl implements StoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Story> getAllStories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Story>  storyList = session.createQuery("from Story").list();
		return storyList;
	}

	public Story getStory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Story story = (Story) session.get(Story.class, id);
		return story;
	}

	public Story addStory(Story story) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(story);
		return story;
	}

	public void updateStory(Story story) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(story);
		session.update(story);
	}

	public void deleteStory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Story p = (Story) session.load(Story.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
