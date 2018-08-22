package com.rsrit.rchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.rchat.models.RchatMessage;

public interface RchatMessageRepo extends JpaRepository<RchatMessage, Integer> {

	RchatMessage findLastByConversation_ConversationId(int conversationId);

}
