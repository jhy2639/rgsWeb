package com.rgsbe.rgsbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.rgsbe.rgsbackend.service.rgsLoginService;

@Controller
@RequiredArgsConstructor
public class rgsLoginController {

//    private final rgsLoginService rgsLoginService;
    @GetMapping("/rgsLogin")
    public String rgsLoginForm(){
        return "rgsLogin";
    }
}
