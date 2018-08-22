package com.rsrit.rchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.rchat.models.RchatConversation;

public interface RchatConversationRepo extends JpaRepository<RchatConversation, Integer> {

}
