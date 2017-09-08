package com.rizvi.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This is our model class and it corresponds to Story table in database
 */
//@XmlRootElement
@Entity
@Table(name = "STORY")
public class Story {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "title")
	String title;

	@Column(name = "author")
	String author;

	@Column(name = "body")
	String body;

	public Story() {
		super();
	}

	public Story(String title, String author, String body) {
		super();
		this.title = title;
		this.author = author;
		this.body = body;
	}

//	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	@XmlElement
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

//	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", author=" + author + ", body=" + body + "]";
	}

}
