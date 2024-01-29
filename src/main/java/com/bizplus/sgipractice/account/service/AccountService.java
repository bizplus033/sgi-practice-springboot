package com.bizplus.sgipractice.account.service;

import com.bizplus.sgipractice.account.repository.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final JpaAccountRepository jpaAccountRepository;


}
