package com.rsrit.rchat.repo;

import java.util.List;

import org.springframework.lang.Nullable;

import com.rsrit.rchat.models.RchatConversation;

public interface RchatConversationCustomRepo {

	public int findConversationByParticipants(String partcipant1UserName, String partcipant2UserName);

	public List<RchatConversation> findByParticipant1UserNameOrParticipant2UserName(@Nullable String user1);

}
