package com.cdac.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDemo {

	//to test this example, URL will be : http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot";
	}
}