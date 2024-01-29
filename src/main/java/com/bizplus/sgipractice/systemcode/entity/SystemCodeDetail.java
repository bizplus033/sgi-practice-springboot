package com.bizplus.sgipractice.systemcode.entity;

import com.bizplus.sgipractice.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "system_code_detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SystemCodeDetail extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_code_id")
    private SystemCode systemCode;

    public static SystemCodeDetail create(String name, SystemCode systemCode) {
        return new SystemCodeDetail(null, name, systemCode);
    }

}
