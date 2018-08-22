package com.rsrit.rchat.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatConversationDao;
import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.repo.RchatMessageCustomRepo;
import com.rsrit.rchat.repo.RchatMessageRepo;

@Service
public class RchatConversationDaoImpl implements RchatConversationDao {

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatMessageRepo messageRepository;

	@Autowired
	RchatMessageCustomRepo messageCustomRepo;

	@Override
	public List<RchatConversation> getConversationsAndDetailsOfLastSentMessageInEachConversation(String userName) {

		List<RchatConversation> listOfConversationsForUser = conversationCustomRepo
				.findByParticipant1UserNameOrParticipant2UserName(userName);

		System.out.println("Number of conversation found for user " + listOfConversationsForUser.size());

		for (RchatConversation conversation : listOfConversationsForUser) {
			int conversation_id = conversation.getConversation_Id();

			System.out.println("process running for " + conversation_id);

			Timestamp lastSentMessageTimeStamp = messageCustomRepo
					.findWhenLastMessageWasSentByTheUserInAConversation(conversation_id, userName);

			conversation.setLastMessageSentAt(lastSentMessageTimeStamp);

			int numberOfUnreadMessages = messageCustomRepo
					.findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(conversation_id,
							userName);

			System.out.println("Number of unread messages of user " + userName + " in conversation " + conversation_id
					+ " are " + numberOfUnreadMessages);

			conversation.setNumberOfUnreadMessages(numberOfUnreadMessages);

		}

		return listOfConversationsForUser;
	}

}
