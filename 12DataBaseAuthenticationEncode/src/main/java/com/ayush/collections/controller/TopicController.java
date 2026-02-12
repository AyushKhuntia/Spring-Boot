package com.ayush.collections.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.collections.entities.Topic;
import com.ayush.collections.service.TopicService;

@RestController
@RequestMapping("/user")
public class TopicController {
	@Autowired
	private TopicService topicService;
	@GetMapping("/hello")
	public String helloUser() {
		return "Hello User! You are authenticated.";
	}
	@GetMapping("/topic/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") Integer id){
		
		Topic topic = topicService.getTopicById(id);
		return new ResponseEntity<Topic>(topic,HttpStatus.OK);
		
	}
	
	@GetMapping("/topic")
	public ResponseEntity<List<Topic>> getAllTopics(){
		
		List<Topic> list = topicService.getAllTopics();
		return new ResponseEntity<List<Topic>>(list,HttpStatus.OK);
	}


    // ADD topic (ROLE_ADMIN)
    @PostMapping("/topic")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
        Topic savedTopic = topicService.addTopic(topic);
        return new ResponseEntity<>(savedTopic, HttpStatus.CREATED);
    }

    // UPDATE topic (ROLE_ADMIN)
    @PutMapping("/topic/{id}")
    public ResponseEntity<Topic> updateTopic(
            @PathVariable("id") Integer id,
            @RequestBody Topic topic) {

        topic.setTopicId(id); // ensure correct ID
        Topic updatedTopic = topicService.updateTopic(topic);
        return new ResponseEntity<>(updatedTopic, HttpStatus.OK);
    }

    // DELETE topic (ROLE_ADMIN)
    @DeleteMapping("/topic/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable("id") Integer id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<>("Topic deleted successfully", HttpStatus.OK);
    }
	
	
}
