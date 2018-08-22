package com.rsrit.rchat.controller;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.service.RchatMessageService;

/*
 * Use WebSockets for message sending
 * 
 */

@RestController
@RequestMapping("/rchat/api/messages/")
public class RchatMessageController {

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatMessageService messageService;

	@RequestMapping("send")
	public RchatMessage sendMessage(@RequestBody RchatMessage messageToBeSent) {
		Validate.notNull(messageToBeSent.getMessageContent(), "Message content cannot be empty");
		Validate.notNull(messageToBeSent.getMessageSender(), "Message should have a Sender");
		Validate.notNull(messageToBeSent.getMessageReceiver(), "Message should have a Receiver");

		return messageService.addMessageToTheConversation(messageToBeSent);
	}

}
