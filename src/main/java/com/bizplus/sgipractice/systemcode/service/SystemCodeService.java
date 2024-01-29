package com.bizplus.sgipractice.systemcode.service;

import com.bizplus.sgipractice.systemcode.dto.ResponseDto;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailRequest;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailResponse;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeResponseDto;
import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import com.bizplus.sgipractice.systemcode.entity.SystemCodeDetail;
import com.bizplus.sgipractice.systemcode.repository.DslSystemCodeDetailRepository;
import com.bizplus.sgipractice.systemcode.repository.JpaSystemCodeDetailRepository;
import com.bizplus.sgipractice.systemcode.repository.JpaSystemCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemCodeService {
    private final JpaSystemCodeRepository systemCodeRepository;
    private final JpaSystemCodeDetailRepository systemCodeDetailRepository;
    private final DslSystemCodeDetailRepository dslSystemCodeDetailRepository;

    public SystemCodeResponseDto systemCodeList() {
        List<SystemCode> all = systemCodeRepository.findAll();
        long count = systemCodeRepository.count();
        return new SystemCodeResponseDto(all, count);
    }

    public ResponseDto systemCodeDetailList() {
        List<SystemCodeDetailResponse> systemCodeDetailResponses
                = dslSystemCodeDetailRepository.findSystemCodeDetailWithSystemCode();
        Long totalCount = dslSystemCodeDetailRepository.totalCountSystemCodeDetail();
        return new ResponseDto(systemCodeDetailResponses, totalCount);
    }

    public void createSystemCodeDetail(SystemCodeDetailRequest request) {
        Long systemCodeId = request.getSystemCodeId();
        SystemCode systemCode
                = systemCodeRepository.findById(systemCodeId)
                .orElseThrow(() -> new RuntimeException("없는 시스템 코드입니다."));
        SystemCodeDetail systemCodeDetail = request.toEntity(systemCode);
        systemCodeDetailRepository.save(systemCodeDetail);
    }
}
