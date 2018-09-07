package com.rsrit.rchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.${profile:test}.properties")
public class RchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RchatApplication.class, args);
	}
}
