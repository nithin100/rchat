package com.rsrit.rchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;

/*
 * Use WebSockets for message sending
 * 
 */

@RestController
@RequestMapping("/rchat/api/messages/")
public class RchatMessageController {

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@RequestMapping("send")
	public void sendMessage(@RequestBody RchatMessage messageToBeSent) {

		if (messageToBeSent.getConversation() != null) {
			// save message directly in message table
		} else {
			conversationCustomRepo.findConversationByParticipants(messageToBeSent.getMessageSender(),
					messageToBeSent.getMessageReceiver());
		}

	}

}
