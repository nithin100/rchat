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

		/*For each conversation set i) Timestamp of most recently sent message
									ii) number of unread messages on receiver end
									iii) other participants name*/
		
		for (RchatConversation conversation : listOfConversationsForUser) {
			int conversation_id = conversation.getConversation_Id();

			Timestamp lastSentMessageTimeStamp = getLastMessageTimestamp(userName, conversation_id);
			int numberOfUnreadMessages = getCountOfUnreadMessages(userName, conversation_id);
			String otherParticipantName = getOtherParticipantNameInConversation(userName, conversation);
			
			conversation.setLastMessageSentAt(lastSentMessageTimeStamp);
			conversation.setNumberOfUnreadMessages(numberOfUnreadMessages);
			conversation.setSecondParticipant(otherParticipantName);

		}

		return listOfConversationsForUser;
	}

	private int getCountOfUnreadMessages(String userName, int conversation_id) {
		int numberOfUnreadMessages = messageCustomRepo
				.findNumberOfUnreadMessagesOfUserInEveryCoversationByCoversationIdAndUserName(conversation_id,
						userName);
		return numberOfUnreadMessages;
	}

	
	private Timestamp getLastMessageTimestamp(String userName, int conversation_id) {
		System.out.println("process running for " + conversation_id);

		Timestamp lastSentMessageTimeStamp = messageCustomRepo
				.findWhenLastMessageWasSentByTheUserInAConversation(conversation_id, userName);
		return lastSentMessageTimeStamp;
	}

	
	private String getOtherParticipantNameInConversation(String userName, RchatConversation conversation) {

		return userName.equals(conversation.getParticipant1UserName()) ? conversation.getParticipant2UserName()
				: conversation.getParticipant1UserName();

	}

}
