package com.rsrit.rchat.service;

import java.util.List;

import com.rsrit.rchat.models.RchatContact;
import com.rsrit.rchat.models.RchatUser;

public interface RchatContactService {
	
	public List<RchatUser> findPossibleUsersWithUsername(String searchUserName);
	
	public RchatContact addContact(RchatContact contact);
	
}
