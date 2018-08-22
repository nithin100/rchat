package com.rsrit.rchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.repo.RchatConversationRepo;
import com.rsrit.rchat.service.RchatConversationService;

@RestController
@RequestMapping("/rchat/api/conversations/")
public class RchatConversationController {

	@Autowired
	RchatConversationRepo conversationsRepo;

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatConversationService conversationService;

	@RequestMapping("{user_name}")
	public List<RchatConversation> getAllConversationsOfUser(@PathVariable("user_name") String userName) {

		return conversationService.findConversationsOfUserByUsername(userName);

	}

}
