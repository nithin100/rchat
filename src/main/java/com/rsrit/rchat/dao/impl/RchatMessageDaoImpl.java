package com.rsrit.rchat.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rsrit.rchat.dao.RchatMessageDao;
import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.repo.RchatConversationCustomRepo;
import com.rsrit.rchat.repo.RchatConversationRepo;
import com.rsrit.rchat.repo.RchatMessageRepo;

@Service
@Transactional
public class RchatMessageDaoImpl implements RchatMessageDao {

	@Autowired
	RchatConversationCustomRepo conversationCustomRepo;

	@Autowired
	RchatMessageRepo messageJpaRepo;

	@Autowired
	RchatConversationRepo conversationJpaRepo;

	@Override
	public RchatMessage addMessageToTheConversation(RchatMessage newMessage) {

		int conversation_Id_ToWhichMessageBelongs = conversationCustomRepo
				.findConversationByParticipants(newMessage.getMessageSender(), newMessage.getMessageReceiver());

		System.out.println(conversation_Id_ToWhichMessageBelongs);

		if (conversation_Id_ToWhichMessageBelongs == 0) {
			// persist message directly as this will automatically create a new conversation
			// in DB
			System.out.println("No conversations exists and hence it should create a new conversation");
			newMessage.setConversation(
					new RchatConversation(newMessage.getMessageReceiver(), newMessage.getMessageSender()));
			return messageJpaRepo.save(newMessage);

		} else {
			// set new message conversation to which it belongs and the save it

			RchatConversation conversationToWhichMessageBelongs = conversationJpaRepo
					.findById(conversation_Id_ToWhichMessageBelongs).get();

			newMessage.setConversation(conversationToWhichMessageBelongs);

			return messageJpaRepo.save(newMessage);
		}

	}

}
