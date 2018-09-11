package com.rsrit.rchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.service.RchatUserService;

@Component
@Profile("test")
public class CommandRunner implements CommandLineRunner {

	@Autowired
	RchatUserService userService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inserting test user to database");
		userService.userRegistrationService(new RchatUser("test", "test", "test@fake.com", "test", "Male", 1, "test"));
		userService.userRegistrationService(new RchatUser("john", "abc", "john@fake.com", "john", "Male", 1, "john"));
	}

}
