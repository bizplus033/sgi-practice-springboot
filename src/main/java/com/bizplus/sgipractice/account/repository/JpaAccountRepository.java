package com.bizplus.sgipractice.account.repository;

import com.bizplus.sgipractice.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<Account, Long> {
}
