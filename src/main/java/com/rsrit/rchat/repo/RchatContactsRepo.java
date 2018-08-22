package com.rsrit.rchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.rchat.models.RchatContact;

public interface RchatContactsRepo extends JpaRepository<RchatContact, Integer> {
	
	//RchatContact findByParticipants(Set<String> participants);
	
}
