package com.bizplus.sgipractice.account.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class AccountWithTotalCountResponse {
    List<AccountResponse> accountResponses;
    Long totalCount;

    public AccountWithTotalCountResponse(List<AccountResponse> accountResponses, Long totalCount) {
        this.accountResponses = accountResponses;
        this.totalCount = totalCount;
    }
}
