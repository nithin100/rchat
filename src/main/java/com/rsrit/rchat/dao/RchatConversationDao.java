package com.rsrit.rchat.dao;

import java.util.List;

import com.rsrit.rchat.models.RchatConversation;

public interface RchatConversationDao {

	public List<RchatConversation> getConversationsAndDetailsOfLastSentMessageInEachConversation(String userName);

}
