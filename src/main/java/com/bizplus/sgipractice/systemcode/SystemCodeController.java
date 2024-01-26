package com.bizplus.sgipractice.systemcode;

import com.bizplus.sgipractice.global.util.NavigationUtil;
import com.bizplus.sgipractice.systemcode.dto.ResponseDto;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailRequest;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeDetailResponse;
import com.bizplus.sgipractice.systemcode.dto.SystemCodeResponseDto;
import com.bizplus.sgipractice.systemcode.entity.SystemCode;
import com.bizplus.sgipractice.systemcode.service.SystemCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.CSS;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/systemCode")
@RequiredArgsConstructor
public class SystemCodeController {
    private List<String> navigationList = new ArrayList<>();
    private final SystemCodeService systemCodeService;
    /**
     * 시스템 코드
     * */
    @GetMapping("/codeList")
    public String codeList(Model model) {
        navigationList = NavigationUtil.setNavigation("기초정보관리", "시스템코드");
        SystemCodeResponseDto systemCodeResponseDto = systemCodeService.systemCodeList();
        model.addAttribute("navigation", navigationList);
        model.addAttribute("systemCodeResponseDto", systemCodeResponseDto);
        model.addAttribute("activeValue", "systemCodeList");
        return "systemCode/systemCodeList";
    }
    /**
     * 공통자료관리
     * */
    @GetMapping("/list")
    public String list(Model model) {
        navigationList = NavigationUtil.setNavigation("기초정보관리", "공통자료관리");
        ResponseDto responseDto = systemCodeService.systemCodeDetailList();
        model.addAttribute("navigation", navigationList);
        model.addAttribute("responseDto", responseDto);
        model.addAttribute("activeValue", "systemCodeDetailList");
        return "systemCode/systemCodeDetailList";
    }

    /**
     * SystemCodeDetail 생성
     * */
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("request", new SystemCodeDetailRequest());
        SystemCodeResponseDto systemCodeResponseDto = systemCodeService.systemCodeList();
        List<SystemCode> systemCodes = systemCodeResponseDto.getSystemCodes();
        model.addAttribute("systemCodes", systemCodes);
        return "systemCode/popupSystemCodeDetailForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute SystemCodeDetailRequest request) {
        systemCodeService.createSystemCodeDetail(request);
        return "redirect:/systemCode/list";
    }

}
