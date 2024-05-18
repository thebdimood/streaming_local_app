package com.enspd.release.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enspd.release.models.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {

    AccountEntity findByName(String name);

    
}
