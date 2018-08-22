package com.rsrit.rchat.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatContactsDao;
import com.rsrit.rchat.models.RchatContact;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.repo.RchatContactsRepo;
import com.rsrit.rchat.repo.RchatUserRepo;

/*
 *toDo: Seperate findingusers from Contacts Repo 
 * 
 */

@Service
public class RchatContactsDaoImpl implements RchatContactsDao {

	@Autowired
	RchatUserRepo userRepo;

	@Autowired
	RchatContactsRepo contactsRepo;

	@Override
	public List<RchatUser> findUsersWithUsernameLike(String searchedUserName) {
		return userRepo.findByUserNameIgnoreCaseContaining(searchedUserName);
	}

	@Override
	public RchatContact addContact(RchatContact contact) {
		return contactsRepo.save(contact);
	}

}
