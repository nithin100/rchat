package com.rsrit.rchat.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.repo.RchatDupUserRepo;

@Transactional
@Service
public class RchatDupUserDao {
	
	@Autowired 
	RchatDupUserRepo dupUserRepo;
	
	

}
