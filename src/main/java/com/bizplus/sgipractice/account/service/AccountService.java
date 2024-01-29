package com.bizplus.sgipractice.account.service;

import com.bizplus.sgipractice.account.dto.AccountResponse;
import com.bizplus.sgipractice.account.dto.AccountSearchFormDto;
import com.bizplus.sgipractice.account.dto.AccountWithTotalCountResponse;
import com.bizplus.sgipractice.account.repository.DslAccountRepository;
import com.bizplus.sgipractice.account.repository.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final JpaAccountRepository jpaAccountRepository;
    private final DslAccountRepository dslAccountRepository;

    /**
     * account list 가져오기
     * */
    public AccountWithTotalCountResponse getAccountList(AccountSearchFormDto search) {
        List<AccountResponse> accountResponses
                = dslAccountRepository.findAccountBySearch(search.getType(), search.getCode(), search.getName());
        Long totalCount = dslAccountRepository.totalCountAccount(search.getType(), search.getCode(), search.getName());
        return new AccountWithTotalCountResponse(accountResponses, totalCount);
    }

}
