package com.rsrit.rchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatMessageDao;
import com.rsrit.rchat.models.RchatMessage;
import com.rsrit.rchat.service.RchatMessageService;

@Service
public class RchatMessageServiceImpl implements RchatMessageService {

	@Autowired
	RchatMessageDao rchatMessageDao;

	@Override
	public RchatMessage addMessageToTheConversation(RchatMessage newMessage) {
		// TODO Auto-generated method stub

		return rchatMessageDao.addMessageToTheConversation(newMessage);
	}

}
