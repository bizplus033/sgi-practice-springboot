package com.bizplus.sgipractice.systemcode.repository;

import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bizplus.sgipractice.systemcode.entity.QSystemCode.systemCode;
import static com.bizplus.sgipractice.systemcode.entity.QSystemCodeDetail.systemCodeDetail;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DslSystemCodeDetailRepository {
    private final JPAQueryFactory query;

    public List<SystemCodeDetailResponse> findSystemCodeDetailWithSystemCode() {
        return query.select(Projections.constructor(SystemCodeDetailResponse.class,
                systemCodeDetail.id,
                systemCodeDetail.name,
                systemCode.codeName))
                .from(systemCodeDetail)
                .innerJoin(systemCodeDetail.systemCode, systemCode)
                .fetch();
    }

    public Long totalCountSystemCodeDetail() {
        Long total = query.select(systemCodeDetail.count())
                .from(systemCodeDetail)
                .fetchOne();

        if (total == null) total = 0L;
        return total;
    }
}
