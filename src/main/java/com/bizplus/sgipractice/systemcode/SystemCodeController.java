package com.bizplus.sgipractice.systemcode;

import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailResponse;
import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import com.bizplus.sgipractice.systemcode.service.SystemCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.CSS;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/systemCode")
@RequiredArgsConstructor
public class SystemCodeController {
    // <a th:href="@{/systemCode/codeList}" class="sidebar-link"
    //                   th:classappend="${active eq 'systemCodeCodeList' ? 'active' : ''}">시스템코드</a>
    //                <a th:href="@{/SystemCode/list}" class="sidebar-link"
    //                   th:classappend="${active == 'systemCodeList' ? 'active' : ''}">공통자료관리</a>
    private final SystemCodeService systemCodeService;
    /**
     * 시스템 코드
     * */
    @GetMapping("/codeList")
    public String codeList(Model model) {
        List<SystemCode> systemCodes = systemCodeService.systemCodeList();
        model.addAttribute("systemCodeCodeList", systemCodes);
        return "systemCode/systemCodeList";
    }
    /**
     * 공통자료관리
     * */
    @GetMapping("/list")
    public String list(Model model) {
        List<SystemCodeDetailResponse> systemCodeDetailResponses = systemCodeService.systemCodeDetailList();
        model.addAttribute("systemCodeDetailList", systemCodeDetailResponses);
        return "systemCode/systemCodeDetailList";
    }

}
