package com.rsrit.rchat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Hello world api
 * 
 */

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@GetMapping
	public String helloWorld() {

		return "Hello world!";
	}

}
