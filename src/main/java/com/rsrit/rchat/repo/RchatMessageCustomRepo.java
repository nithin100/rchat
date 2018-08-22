package com.rsrit.rchat.repo;

import java.sql.Timestamp;

public interface RchatMessageCustomRepo {

	int findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(int conversationId,
			String userName);

	Timestamp findWhenLastMessageWasSentByTheUserInAConversation(int conversation_id, String senderName);

}
