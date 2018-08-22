package com.rsrit.rchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.exceptions.ConflictingUserException;
import com.rsrit.rchat.exceptions.UserAlreadyExistedException;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.service.RchatUserService;

@RestController
@RequestMapping("/rchat/api/user/")
public class RchatUserRegistrationController {

	@Autowired
	RchatUserService userService;

	@PostMapping("registration")
	public RchatUser registration(@RequestBody RchatUser newUser) {
		try {
			return userService.userRegistrationService(newUser);
		} catch (UserAlreadyExistedException existingUserException) {
			throw new ConflictingUserException("User with the email or username already existed");
		}
	}

}
