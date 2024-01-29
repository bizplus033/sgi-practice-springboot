package com.bizplus.sgipractice.account.repository;

import com.bizplus.sgipractice.account.dto.AccountResponse;
import com.bizplus.sgipractice.account.dto.AccountSearchFormDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bizplus.sgipractice.account.entity.QAccount.account;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DslAccountRepository {
    private final JPAQueryFactory query;

    public List<AccountResponse> findAccountBySearch(String type, String code, String name) {
        return query.select(projectionSelectAccount())
                .from(account)
                .where(toBooleanBuilder(type, code, name))
                .fetch();
    }

    private static ConstructorExpression<AccountResponse> projectionSelectAccount() {
        return Projections.constructor(AccountResponse.class,
                account.id,
                account.code,
                account.name,
                account.type,
                account.businessNumber,
                account.ceo,
                account.etc);
    }

    private BooleanBuilder toBooleanBuilder(String type, String code, String name) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(likeAccountType(type));
        booleanBuilder.and(likeAccountCode(code));
        booleanBuilder.and(likeAccountName(name));

        return booleanBuilder;
    }

    private BooleanExpression likeAccountType(String type) {
        String condition = type == null ? "" : type;
        return account.type.likeIgnoreCase("%" + condition + "%");
    }

    private BooleanExpression likeAccountCode(String code) {
        String condition = code == null ? "" : code;
        return account.code.likeIgnoreCase("%" + condition + "%");
    }
    private BooleanExpression likeAccountName(String name) {
        String condition = name == null ? "" : name;
        return account.name.likeIgnoreCase("%" + condition + "%");
    }

    public Long totalCountAccount() {
        return query
                .select(account.count())
                .from()
                .fetchOne();
    }
}


