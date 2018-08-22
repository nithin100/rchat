package com.rsrit.rchat.repo;

public interface RchatMessageCustomRepo {

	int findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(int conversationId,String userName);

}
