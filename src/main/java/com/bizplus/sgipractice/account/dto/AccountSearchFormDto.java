package com.bizplus.sgipractice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountSearchFormDto {
    private final String type;
    private final String code;
    private final String name;

}
