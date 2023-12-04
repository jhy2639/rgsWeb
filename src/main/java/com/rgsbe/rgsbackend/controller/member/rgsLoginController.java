package com.rgsbe.rgsbackend.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class rgsLoginController {

    @GetMapping("/rgsLogin")
    public String loginProcess() {
        return "rgsLogin";
    }
}
