package com.bizplus.sgipractice.account.controller;

import com.bizplus.sgipractice.account.dto.AccountSearchFormDto;
import com.bizplus.sgipractice.account.dto.AccountWithTotalCountResponse;
import com.bizplus.sgipractice.account.dto.CreateAccountRequest;
import com.bizplus.sgipractice.account.service.AccountService;
import com.bizplus.sgipractice.global.util.NavigationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private List<String> navigationList = new ArrayList<>();
    private final AccountService accountService;

    /**
     * 거래처 리스트 출력
     * */
    @GetMapping("/list")
    public String accountList(Model model, AccountSearchFormDto searchFormDto) {
        navigationList = NavigationUtil.setNavigation("거래처 관리", "거래처 정보");
        AccountWithTotalCountResponse accountList = accountService.getAccountList(searchFormDto);

        model.addAttribute("navigation", navigationList);
        model.addAttribute("searchFormDto", searchFormDto);
        model.addAttribute("accountList", accountList);
        return "account/accountList";
    }

    /**
     * 생성
     */
    @GetMapping("/list/create")
    public String createAccount(CreateAccountRequest request) {
        accountService.createAccount(request);
        return null;
    }
}
