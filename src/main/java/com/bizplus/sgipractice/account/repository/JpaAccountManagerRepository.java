package com.bizplus.sgipractice.account.repository;

import com.bizplus.sgipractice.account.entity.AccountManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountManagerRepository extends JpaRepository<AccountManager, Long> {
}
