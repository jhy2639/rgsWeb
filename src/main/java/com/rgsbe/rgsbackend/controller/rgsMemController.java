package com.rgsbe.rgsbackend.controller;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import com.rgsbe.rgsbackend.service.rgsMemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class rgsMemController {

    private final rgsMemService rgsMemService;

    // 회원가입
    @GetMapping("/rgsJoin/save")
    public String memberJoin() {
        return "memberForm/rgsJoin";
    }

    @PostMapping("/rgsJoin/save")
    public String memberJoinSave(@ModelAttribute rgsMemDTO rgsMemDTO) {
        rgsMemService.memberSave(rgsMemDTO);
        return "memberForm/rgsLogin";
    }

    // 로그인
    @GetMapping("/rgsLogin")
    public String memberLogin() {
        return "memberForm/rgsLogin";
    }

    @PostMapping("/rgsLogin")
    public String memberLoginDone(@ModelAttribute rgsMemDTO rgsMemDTO,
                                  HttpSession session) {
        rgsMemDTO loginResult = rgsMemService.memberLogin(rgsMemDTO);
        if(loginResult != null){
            System.out.println("성공");
            //로그인 성공
            session.setAttribute("loginID", loginResult.getMemID());
            return "main";
        } else {
            System.out.println("실패");
            //로그인 실패
            return "memberForm/rgsLogin";
        }
    }


}
