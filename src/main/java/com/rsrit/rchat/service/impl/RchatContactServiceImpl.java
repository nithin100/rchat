package com.rsrit.rchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatContactsDao;
import com.rsrit.rchat.models.RchatContact;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.service.RchatContactService;

@Service
public class RchatContactServiceImpl implements RchatContactService {

	@Autowired
	RchatContactsDao contactsDao;

	@Override
	public List<RchatUser> findPossibleUsersWithUsername(String searchUserName) {
		return contactsDao.findUsersWithUsernameLike(searchUserName);
	}

	@Override
	public RchatContact addContact(RchatContact contact) {
		return contactsDao.addContact(contact);
	}

}
