package com.rsrit.rchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.rchat.models.RchatDupUser;

public interface RchatDupUserRepo extends JpaRepository<RchatDupUser, Integer> {

}
