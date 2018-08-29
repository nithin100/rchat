package com.rsrit.rchat.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.repo.RchatConversationRepo;

@Transactional
@Repository
public class RchatConversationCustomRepoImpl implements RchatConversationCustomRepo {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	RchatConversationRepo conversationRepo;

	private static final String QUERY_FOR_RETRIEVING_CONVERSATION_WITH_PARTICIPANTS = "SELECT conversation_Id FROM rchat_conversations WHERE participant_user1=? AND participant_user2=? OR participant_user1=? AND participant_user2=?";

	private static final String QUERY_FOR_RETRIEVING_CONVERSATIONS_OF_USER = "SELECT * FROM rchat_conversations WHERE participant_user1=? OR participant_user2=?";

	@Override
	public int findConversationByParticipants(String partcipant1UserName, String partcipant2UserName) {
		
		Query nativeQuery = entityManager.createNativeQuery(QUERY_FOR_RETRIEVING_CONVERSATION_WITH_PARTICIPANTS);

		nativeQuery.setParameter(1, partcipant1UserName);
		nativeQuery.setParameter(2, partcipant2UserName);
		nativeQuery.setParameter(3, partcipant2UserName);
		nativeQuery.setParameter(4, partcipant1UserName);

		int conversation_id = (((int) nativeQuery.getResultList().size() == 0) ? 0
				: (int) nativeQuery.getResultList().get(0));

		return conversation_id;
	}

	@Override
	public List<RchatConversation> findByParticipant1UserNameOrParticipant2UserName(String user1) {

		// Query findConversationsOfUser =
		// entityManager.createNativeQuery(QUERY_FOR_RETRIEVING_CONVERSATIONS_OF_USER);

		Query findConversationsOfUser = entityManager
				.createQuery("FROM RchatConversation AS c WHERE c.participant1UserName=? OR c.participant2UserName=?");

		// System.out.println(user1);

		findConversationsOfUser.setParameter(0, user1);
		findConversationsOfUser.setParameter(1, user1);

		List<RchatConversation> listOfConversationsOfUser = findConversationsOfUser.getResultList();

		// System.out.println(listOfConversationsOfUser.get(0));

		return listOfConversationsOfUser;
	}

}
