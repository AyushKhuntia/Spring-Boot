package com.example.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContainer {

	@RequestMapping(value="/")
	public String getHelloWorld() {
		return "Hello this is using Ecclispe";
	}
}
