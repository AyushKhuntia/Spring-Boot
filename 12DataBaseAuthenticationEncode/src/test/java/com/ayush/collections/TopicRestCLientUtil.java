package com.ayush.collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ayush.collections.entities.Topic;

import org.apache.commons.codec.binary.Base64;

public class TopicRestCLientUtil {
	
	public void getTopicByIdDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/topic/{id}";
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		ResponseEntity<Topic> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Topic.class, 2);
		Topic topic = responseEntity.getBody();
		System.out.println(topic);
	}
	
	public void getAllTopicsDemo() {
//		This line will create HttpHeaders
		HttpHeaders headers = getHeaders();
		
//		Creating Main instance for Entire RestTemplate Object
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/user/topic";
		
//		Preparing Request
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
//		Calling Exchange Method ==> Get Call
		ResponseEntity<Topic[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Topic[].class);
		
		System.out.println(responseEntity.getStatusCodeValue());
		Topic[] topics = responseEntity.getBody();
		for(Topic t : topics) {
			System.out.println(t);
		}
		
	}
	
	public void addTopicDemo() {
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/topic";
		Topic topic = new Topic();
		topic.setTitle("Rest Template Execution");
		topic.setCategory("SpringBoot");
		
		HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		System.out.println(responseEntity.getStatusCodeValue());
		
	}
	
	public void updateTopicDemo() {
		
	}
	
	public void deleteTopicDemo() {
		
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/user/topic/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, void.class,4);
		
	}
	
	private HttpHeaders getHeaders() {

	    String credentials = "ayush:ayush";
	    String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", "Basic " + encodedCredentials);

	    return headers;
	}

	
	public static void main(String[] args) {
		TopicRestCLientUtil obj = new TopicRestCLientUtil();
//		obj.getTopicByIdDemo();
		obj.getAllTopicsDemo();
		
	}
}
