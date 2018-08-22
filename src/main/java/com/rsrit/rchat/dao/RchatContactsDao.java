package com.rsrit.rchat.dao;

import java.util.List;

import com.rsrit.rchat.models.RchatContact;
import com.rsrit.rchat.models.RchatUser;

public interface RchatContactsDao {

	public List<RchatUser> findUsersWithUsernameLike(String searchedUserName);
	
	public RchatContact addContact(RchatContact contact);

}
