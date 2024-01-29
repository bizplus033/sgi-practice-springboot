package com.bizplus.sgipractice.account.entity;

import com.bizplus.sgipractice.common.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String type;                   // 거래처 유형

    private String name;

    @Column(name = "business_number")
    private String businessNumber;         // 사업자 번호

    private String ceo;

    @Column(name = "business_type")
    private String businessType;           // 업종

    @Column(name = "business_category")
    private String businessCategory;        // 업태

    private String tel;

    private String fax;

    private String email;

    @Column(name = "zip_code")
    private String zipCode;                 // 우편번호

    private String address;

    @Column(name = "address_detail")
    private String addressDetail;

    private String etc;

}
