package com.ayush.collections.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="topics_tbl")
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topic_id")
	private int topicId;
	
	@Column(name="title",length=100,nullable=false)
	private String title;
	
	@Column(name="category",length=50,nullable=false)
	private String category;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Topic(int topicId, String title, String category) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.category = category;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title + ", category=" + category + "]";
	}
	
	
	
	
}
