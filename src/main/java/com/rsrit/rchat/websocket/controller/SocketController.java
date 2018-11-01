package com.rsrit.rchat.websocket.controller;

import java.security.Principal;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.service.RchatMessageService;

/*
 * Controller for handling Web socket message receiving and forwarding
 * 
 */

@Controller
public class SocketController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatMessageService messageService;

	@MessageMapping("/stomp/socket")
	public RchatMessage onMessageReceival(@RequestBody RchatMessage messageToBeSent, Principal user,
			@Header("simpSessionId") String sessionId) {
		
		Validate.notNull(messageToBeSent.getMessageContent(), "Message content cannot be empty");
		Validate.notNull(messageToBeSent.getMessageSender(), "Message should have a Sender");
		Validate.notNull(messageToBeSent.getMessageReceiver(), "Message should have a Receiver");

		simpMessagingTemplate.convertAndSendToUser(messageToBeSent.getMessageReceiver(), "/user/rchat/chat/queue",
				messageToBeSent.getMessageContent());

		return messageService.addMessageToTheConversation(messageToBeSent);
	}

}
