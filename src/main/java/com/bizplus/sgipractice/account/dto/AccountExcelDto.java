package com.bizplus.sgipractice.account.dto;

import com.bizplus.sgipractice.global.annotation.ExcelColumn;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class AccountExcelDto {

    @ExcelColumn(headerName = "코드")
    private String code;

    @ExcelColumn(headerName = "거래처 유형")
    private String type;                   // 거래처 유형 : 매입거래처 or 매출거래처 or 매입/매출거래처

    @ExcelColumn(headerName = "거래처명")
    private String name;

    @ExcelColumn(headerName = "사업자 번호")
    private String businessNumber;         // 사업자 번호

    @ExcelColumn(headerName = "대표")
    private String ceo;

    @ExcelColumn(headerName = "비고")
    private String etc;
}
