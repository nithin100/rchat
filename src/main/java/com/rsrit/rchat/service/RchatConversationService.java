package com.rsrit.rchat.service;

import java.util.List;

import com.rsrit.rchat.models.RchatConversation;

public interface RchatConversationService {

	public List<RchatConversation> findConversationsOfUserByUsername(String user_name);

}
