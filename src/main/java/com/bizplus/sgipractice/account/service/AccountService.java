package com.bizplus.sgipractice.account.service;

import com.bizplus.sgipractice.account.dto.*;
import com.bizplus.sgipractice.account.entity.Account;
import com.bizplus.sgipractice.account.repository.DslAccountRepository;
import com.bizplus.sgipractice.account.repository.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final JpaAccountRepository jpaAccountRepository;
    private final DslAccountRepository dslAccountRepository;
    private final ModelMapper modelMapper;

    /**
     * account list 가져오기
     * */
    public AccountWithTotalCountResponse getAccountList(AccountSearchFormDto search) {
        List<AccountResponse> accountResponses
                = dslAccountRepository.findAccountBySearch(search.getType(), search.getCode(), search.getName());
        Long totalCount = dslAccountRepository.totalCountAccount(search.getType(), search.getCode(), search.getName());
        return new AccountWithTotalCountResponse(accountResponses, totalCount);
    }

    @Transactional
    public void createAccount(CreateAccountRequest request) {
        Account entity = request.toEntity();
        log.info("account = {}", entity);
        jpaAccountRepository.save(entity);
    }

    public Account getAccount(Long id) {
        return jpaAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void updateAccount(UpdateAccountRequest request) {
        Account account = jpaAccountRepository.findById(request.getId())
                .orElseThrow(EntityNotFoundException::new);

        modelMapper.map(request,account);
    }
}
