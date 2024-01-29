package com.bizplus.sgipractice.account.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class AccountResponse {
    private final Long id;
    private final String code;
    private final String name;
    private final String type;
    private final String businessNumber;
    private final String ceo;
    private final String etc;
    @QueryProjection
    public AccountResponse(Long id, String code,
                           String name, String type,
                           String businessNumber,
                           String ceo, String etc) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.businessNumber = businessNumber;
        this.ceo = ceo;
        this.etc = etc;
    }
}
