package com.bizplus.sgipractice.systemcode.repository;

import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSystemCodeRepository extends JpaRepository<SystemCode, Long> {

    long count();
}
