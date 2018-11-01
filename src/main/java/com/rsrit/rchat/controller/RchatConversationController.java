package com.rsrit.rchat.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.repo.RchatConversationRepo;
import com.rsrit.rchat.service.RchatConversationService;

@RestController
@RequestMapping("/rchat/api/conversations")
public class RchatConversationController {

	@Autowired
	RchatConversationRepo conversationsRepo;

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatConversationService conversationService;

	@GetMapping
	public List<RchatConversation> getAllConversationsOfUser(Principal principal) {
		System.out.println(principal);
		return conversationService.findConversationsOfUserByUsername(principal.getName());

	}

}
