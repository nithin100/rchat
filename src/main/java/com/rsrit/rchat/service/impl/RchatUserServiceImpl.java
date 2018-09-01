package com.rsrit.rchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatUserDao;
import com.rsrit.rchat.exceptions.UserAlreadyExistedException;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.service.RchatUserService;

@Service
public class RchatUserServiceImpl implements RchatUserService {

	@Autowired
	RchatUserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public RchatUser userRegistrationService(RchatUser newUser) {
		String encodedPassword = passwordEncoder.encode(newUser.getPassword());
		newUser.setPassword(encodedPassword);

		boolean isExistingUser = userDao.isExistingUser(newUser);
		if (!isExistingUser) {
			return userDao.registeration(newUser);
		} else {
			throw new UserAlreadyExistedException();
		}
	}

}
