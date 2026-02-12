package com.ayush.collections.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ayush.collections.DAO.TopicDAO;
import com.ayush.collections.entities.Topic;
import com.ayush.collections.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDAO topicDAO;

    @Override
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<Topic> getAllTopics() {
        return topicDAO.findAll();
    }
    
    @Override
    @Secured({"ROLE_ADMIN","ROlE_USER"})
    public Topic getTopicById(int topicId) {
        return topicDAO.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with id: " + topicId));
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public Topic addTopic(Topic topic) {
        return topicDAO.save(topic);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public void deleteTopic(int topicId) {
        topicDAO.deleteById(topicId);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Topic updateTopic(Topic topic) {
    	
    		Topic topicDbObj = getTopicById(topic.getTopicId());
    		if(topic.getTitle() != null) {
    			topicDbObj.setTitle(topic.getTitle());
    		} 
    		if(topic.getCategory() != null) {
    			topicDbObj.setCategory(topic.getCategory());
    		}
        return topicDAO.save(topicDbObj);
    }
}
