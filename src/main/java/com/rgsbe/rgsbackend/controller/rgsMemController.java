package com.rgsbe.rgsbackend.controller;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import com.rgsbe.rgsbackend.service.rgsMemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
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
    @GetMapping("/api/rgsLogin")
    public String memberLogin() {

        return "memberForm/rgsLogin";
    }

    @PostMapping("/api/rgsLogin")
    public String memberLoginDone(@ModelAttribute rgsMemDTO rgsMemDTO,
                                  HttpSession session) {
        rgsMemDTO loginResult = rgsMemService.memberLogin(rgsMemDTO);

        if(loginResult != null){
            //로그인 성공
            session.setAttribute("loginID", loginResult.getMemID());
            return "main";
        } else {
            System.out.println("컨트롤러에서 로그인 실패");
            //로그인 실패
            return "memberForm/rgsLogin";
        }
    }


}
