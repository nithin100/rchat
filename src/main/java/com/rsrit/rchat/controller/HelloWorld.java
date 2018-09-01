package com.rsrit.rchat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorld {
	
	@GetMapping
	@MessageMapping("/rchat")
	@SendTo("/app/messages")
	public String helloWorld() {
		return "Hello World";
	}

}
