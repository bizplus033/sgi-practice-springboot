package com.bizplus.sgipractice.account.dto;

import com.bizplus.sgipractice.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    private String code;
    private String type;
    private String name;
    private String businessNumber;
    private String ceo;
    private String businessType;
    private String businessCategory;
    private String tel;
    private String fax;
    private String email;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String etc;

    public Account toEntity() {
        return new Account(null, code, type, name, businessNumber, ceo, businessType, businessCategory, tel, fax,
                email, zipCode, address, addressDetail, etc);
    }
}
