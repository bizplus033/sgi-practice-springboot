package com.bizplus.sgipractice.systemcode.dto;

import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import com.bizplus.sgipractice.systemcode.entity.SystemCodeDetail;
import lombok.Getter;

@Getter
public class SystemCodeDetailRequest {
    private String name;
    private Long systemCodeId;

    public SystemCodeDetail toEntity(SystemCode systemCode) {
        return SystemCodeDetail.create(name, systemCode);
    }
}
