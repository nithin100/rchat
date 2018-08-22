package com.rsrit.rchat.repo.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.rsrit.rchat.repo.RchatMessageCustomRepo;

@Service
@SuppressWarnings("unchecked")
public class RchatMessageCustomRepoImpl implements RchatMessageCustomRepo {

	@PersistenceContext
	EntityManager entityManager;

	// private static final String
	// QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID =
	// "from RchatMessage as m where m.messageReceiver=? and m.isMessageRead=false";

	private static final String QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID = "SELECT COUNT(*) FROM rchat_message WHERE conversation_id=? AND is_message_read=? AND message_receiver=?";

	private static final String QUERY_TO_FIND_SENT_MESSAGES_BY_USER_IN_A_CONVERSATION = "SELECT message_sent_at FROM rchat_message WHERE conversation_id= :id AND message_sender= :senderName";

	@Override
	public int findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(int conversationId,
			String userName) {
		try {

			List<Object> coutOfUnreadReceivedMessagesInAConversation = (List<Object>) entityManager
					.createNativeQuery(QUERY_TO_FIND_NUMBER_OF_UREAD_MESSAGES_RECIEVED_BY_A_USER_BY_COVERSATION_ID)
					.setParameter(1, conversationId).setParameter(2, 0).setParameter(3, userName).getResultList();

			System.out.println(((BigInteger) coutOfUnreadReceivedMessagesInAConversation.get(0)).intValue());

			return ((BigInteger) coutOfUnreadReceivedMessagesInAConversation.get(0)).intValue();

		} catch (Exception e) {

			return 0;
		}
	}

	@Override
	public Timestamp findWhenLastMessageWasSentByTheUserInAConversation(int conversation_id, String senderName) {

		Query nativeQueryToFindSentMessagesByUserInSingleConversation = entityManager
				.createNativeQuery(QUERY_TO_FIND_SENT_MESSAGES_BY_USER_IN_A_CONVERSATION);

		nativeQueryToFindSentMessagesByUserInSingleConversation.setParameter("id", conversation_id);
		nativeQueryToFindSentMessagesByUserInSingleConversation.setParameter("senderName", senderName);
		try {

			List<Object> listOfSentMessages = (List<Object>) nativeQueryToFindSentMessagesByUserInSingleConversation
					.getResultList();

			System.out.println(listOfSentMessages.get(listOfSentMessages.size() - 1));

			return (Timestamp) listOfSentMessages.get(listOfSentMessages.size() - 1);
		} catch (Exception e) {

			return null;
		}
	}

}
