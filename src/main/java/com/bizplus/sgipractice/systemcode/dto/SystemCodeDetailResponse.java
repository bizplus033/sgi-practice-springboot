package com.bizplus.sgipractice.systemcode.dto;

import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import lombok.Getter;

@Getter
public class SystemCodeDetailResponse {
    private final Long id;
    private final String systemCodeDetailName;
    private final String systemCodeName;

    public SystemCodeDetailResponse(Long id,
                                    String systemCodeDetailName,
                                    String systemCodeName) {
        this.id = id;
        this.systemCodeDetailName = systemCodeDetailName;
        this.systemCodeName = systemCodeName;
    }
}
