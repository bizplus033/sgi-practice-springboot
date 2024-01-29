package com.bizplus.sgipractice.systemcode.repository;

import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DslSystemCodeDetailRepositoryTest {

    @Autowired DslSystemCodeDetailRepository dslSystemCodeDetailRepository;

    @Test
    void findSystemCodeDetailWithSystemCode_test() throws Exception {

        List<SystemCodeDetailResponse> systemCodeDetailWithSystemCode = dslSystemCodeDetailRepository.findSystemCodeDetailWithSystemCode();
        for (SystemCodeDetailResponse systemCodeDetailResponse : systemCodeDetailWithSystemCode) {
            System.out.println(systemCodeDetailResponse.getSystemCodeName());
        }
    }
}