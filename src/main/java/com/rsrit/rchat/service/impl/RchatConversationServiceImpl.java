package com.rsrit.rchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatConversationDao;
import com.rsrit.rchat.models.RchatConversation;
import com.rsrit.rchat.service.RchatConversationService;

@Service
public class RchatConversationServiceImpl implements RchatConversationService {

	@Autowired
	RchatConversationDao conversationsDao;

	@Override
	public List<RchatConversation> findConversationsOfUserByUsername(String user_name) {
		return conversationsDao.getConversationsAndDetailsOfLastSentMessageInEachConversation(user_name);
	}

}
