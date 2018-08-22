package com.rsrit.rchat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import com.rsrit.rchat.models.RchatUser;

public interface RchatUserRepo extends JpaRepository<RchatUser, Integer> {

	public RchatUser findByEmailOrUserName(@Nullable String email, @Nullable String userName);

	public List<RchatUser> findByUserNameIgnoreCaseContaining(String userName);

}
