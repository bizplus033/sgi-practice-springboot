package com.bizplus.sgipractice.account.controller;

import com.bizplus.sgipractice.account.dto.AccountExcelDto;
import com.bizplus.sgipractice.account.dto.AccountResponse;
import com.bizplus.sgipractice.account.dto.AccountSearchFormDto;
import com.bizplus.sgipractice.account.dto.AccountWithTotalCountResponse;
import com.bizplus.sgipractice.account.service.AccountService;
import com.bizplus.sgipractice.global.util.ExcelUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AccountExcelController {
    private final AccountService accountService;
    private final ExcelUtils excelUtils;

    @GetMapping("/accountExcel")
    public void excelDownload(HttpServletResponse response, AccountSearchFormDto searchFormDto) {
        log.info("/accountExcel 요청 도착");

        List<AccountResponse> accountResponses
                = accountService
                .getAccountList(searchFormDto)
                .getAccountResponses();

        List<AccountExcelDto> accountExcelDtos
                = accountResponses
                .stream()
                .map(AccountResponse::toAccountExcelDto)
                .collect(Collectors.toList());

        excelUtils.excelDownload(accountExcelDtos, response);

    }
}
