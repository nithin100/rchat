package com.rsrit.rchat.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import com.rsrit.rchat.models.RchatMessage;

@Controller
public class HelloWorld {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	
	@MessageMapping("/stomp/socket")
	public String helloWorld(@RequestBody RchatMessage msg,Principal user, @Header("simpSessionId") String sessionId) {
		System.out.println(user);
		System.out.println("Trying to send message to "+msg.getMessageReceiver());
		simpMessagingTemplate.convertAndSendToUser(msg.getMessageReceiver(), "/user/rchat/chat/queue", msg.getMessageContent());
		return "Hello World";
	}

}
