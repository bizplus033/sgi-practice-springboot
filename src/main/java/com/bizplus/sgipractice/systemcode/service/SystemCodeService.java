package com.bizplus.sgipractice.systemcode.service;

import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import com.bizplus.sgipractice.systemcode.repository.SystemCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemCodeService {
    private final SystemCodeRepository systemCodeRepository;

    public List<SystemCode> systemCodeList() {
        return systemCodeRepository.findAll();
    }
}
