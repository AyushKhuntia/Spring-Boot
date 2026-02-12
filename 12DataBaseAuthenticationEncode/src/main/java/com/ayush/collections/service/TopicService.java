package com.ayush.collections.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ayush.collections.entities.Topic;

public interface TopicService {

	
	public abstract List<Topic> getAllTopics();
	
	
	public abstract Topic getTopicById(int topicId);
	
	
	public abstract Topic addTopic(Topic topic);
	
//	@Secured({"ROLE_ADMIN"})
	public abstract void deleteTopic(int topicId);
	
//	@Secured({"ROLE_ADMIN"})
	public abstract Topic updateTopic(Topic topic);

}
