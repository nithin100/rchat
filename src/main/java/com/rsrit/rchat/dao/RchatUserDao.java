package com.rsrit.rchat.dao;

import com.rsrit.rchat.models.RchatUser;

public interface RchatUserDao {

	public RchatUser registeration(RchatUser newUser);
	
	public boolean isExistingUser(RchatUser newUser);

}
