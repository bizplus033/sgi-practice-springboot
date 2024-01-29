package com.bizplus.sgipractice.systemcode.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JpaSystemCodeRepositoryTest {

    @Autowired JpaSystemCodeRepository systemCodeRepository;

    @Test
    void count_test() throws Exception {
        long count = systemCodeRepository.count();
        System.out.println(count);
    }

}