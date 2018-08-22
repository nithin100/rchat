package com.rsrit.rchat.repo.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.repo.RchatMessageCustomRepo;

@Service
public class RchatMessageCustomRepoImpl implements RchatMessageCustomRepo {

	@PersistenceContext
	EntityManager entityManager;

	// private static final String
	// QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID =
	// "from RchatMessage as m where m.messageReceiver=? and m.isMessageRead=false";

	private static final String QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID = "SELECT COUNT(*) FROM rchat_message WHERE conversation_id=? AND is_message_read=? AND message_receiver=?";

	@Override
	public int findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(int conversationId,
			String userName) {
		List<Object> allUnreadMessages = (List<Object>) entityManager
				.createNativeQuery(QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID)
				.setParameter(1, conversationId).setParameter(2, 0).setParameter(3, userName).getResultList();

		System.out.println(((BigInteger) allUnreadMessages.get(0)).intValue());
		return ((BigInteger) allUnreadMessages.get(0)).intValue();
	}

}
