package com.rsrit.rchat.dao;

import com.rsrit.rchat.models.RchatMessage;

public interface RchatMessageDao {

	RchatMessage addMessageToTheConversation(RchatMessage newMessage);

}
