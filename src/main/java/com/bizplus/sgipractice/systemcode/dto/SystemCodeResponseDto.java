package com.bizplus.sgipractice.systemcode.dto;

import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import lombok.Getter;

import java.util.List;
@Getter
public class SystemCodeResponseDto {
    List<SystemCode> systemCodes;
    long count;

    public SystemCodeResponseDto(List<SystemCode> systemCodes,
                                 long count) {
        this.systemCodes = systemCodes;
        this.count = count;
    }
}
