package com.rsrit.rchat.security;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.repo.RchatUserRepo;

//toDo: Validate provided username is an email type or just a plain name

@Service
@Transactional
public class UserService implements UserDetailsService {

	private RchatUserRepo userRepo;

	public UserService(RchatUserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String nameOrEmail) throws UsernameNotFoundException {
		
		RchatUser user = userRepo.findByEmailOrUserName(null, nameOrEmail);
		if (user != null) {
			User userDetails = new User(user.getUserName(), user.getPassword(), true, true, true, true,
					grantedAuthorities());
			return userDetails;
		} else {
			throw new RuntimeException();
		}

	}

	private List<GrantedAuthority> grantedAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

}
