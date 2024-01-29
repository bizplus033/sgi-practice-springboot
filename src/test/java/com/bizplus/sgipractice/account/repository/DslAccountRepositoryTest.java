package com.bizplus.sgipractice.account.repository;

import com.bizplus.sgipractice.account.dto.AccountResponse;
import com.bizplus.sgipractice.account.dto.AccountSearchFormDto;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DslAccountRepositoryTest {

    @Autowired
    private DslAccountRepository dslAccountRepository;

    @Test
    void findAccountBySearch_test() throws Exception {
        // given
        String type = "매출거래처";
        String code = "WB";
        String name = "준몰드";


        // when
        List<AccountResponse> accountBySearchNull = dslAccountRepository.findAccountBySearch(null, null, null);
        List<AccountResponse> accountBySearch1 = dslAccountRepository.findAccountBySearch(type, code, null);
        List<AccountResponse> accountBySearch2 = dslAccountRepository.findAccountBySearch(null, null, name);

        // then
        assertThat(accountBySearchNull.size()).isEqualTo(19);
        assertThat(accountBySearch1.size()).isEqualTo(1);
        assertThat(accountBySearch2.size()).isEqualTo(1);
        assertThat(accountBySearch1.get(0).getName()).isEqualTo("우보테크");
        assertThat(accountBySearch2.get(0).getName()).isEqualTo("준몰드");
    }



}