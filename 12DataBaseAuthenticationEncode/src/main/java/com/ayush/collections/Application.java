package com.ayush.collections;

import com.ayush.collections.controller.TopicController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    private final TopicController topicController;

    Application(TopicController topicController) {
        this.topicController = topicController;
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		BCryptPasswordEncoder pswd = new BCryptPasswordEncoder();
//		System.out.println("Ayush"+pswd.matches("ayush","$2a$10$.MueZgKvr1UNZ7/UTU3iqee4HIJBsCxyqabu4YpnbXh3ffKGMAPjy"));
//		
//		System.out.println("Litu"+pswd.encode("litu"));
		
	}

}
