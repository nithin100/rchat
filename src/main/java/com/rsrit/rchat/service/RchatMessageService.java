package com.rsrit.rchat.service;

import com.rsrit.rchat.models.RchatMessage;

public interface RchatMessageService {

	RchatMessage addMessageToTheConversation(RchatMessage newMessage);

}
