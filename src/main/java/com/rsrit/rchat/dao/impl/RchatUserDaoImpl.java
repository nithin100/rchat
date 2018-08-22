package com.rsrit.rchat.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.dao.RchatUserDao;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.repo.RchatUserRepo;

@Transactional
@Service
public class RchatUserDaoImpl implements RchatUserDao {

	@Autowired
	RchatUserRepo userRepository;

	@Override
	public RchatUser registeration(RchatUser newUser) {
		userRepository.save(newUser);
		return newUser;
	}

	@Override
	public boolean isExistingUser(RchatUser newUser) {
		RchatUser user = userRepository.findByEmailOrUserName(newUser.getEmail(), newUser.getUserName());
		if (user != null) {
			return true;
		}
		return false;
	}

}
