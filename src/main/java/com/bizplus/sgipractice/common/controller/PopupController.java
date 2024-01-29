package com.bizplus.sgipractice.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupController {

    /**
     * 팝업창에서 할일 완료후 팝업창 종료
     * */
    @GetMapping("/popup-close")
    public String popupClose() {
        return "../static/script/popup-close";
    }
}
