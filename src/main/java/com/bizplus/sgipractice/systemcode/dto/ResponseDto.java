package com.bizplus.sgipractice.systemcode.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class ResponseDto {
    List<SystemCodeDetailResponse> systemCodeDetailResponses;
    Long total;

    public ResponseDto(List<SystemCodeDetailResponse> systemCodeDetailResponses,
                       Long total) {
        this.systemCodeDetailResponses = systemCodeDetailResponses;
        this.total = total;
    }
}
