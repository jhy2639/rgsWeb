package com.rgsbe.rgsbackend.controller.member;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import com.rgsbe.rgsbackend.service.rgsMemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class rgsJoinController {

    // 생성자 주입
    private final rgsMemService rgsMemService;

    @GetMapping("/rgsJoin/save")
    public String memberJoin() {
        return "rgsJoin";
    }

    @PostMapping("/rgsJoin/save")
    public String memberJoinSave(@ModelAttribute rgsMemDTO rgsMemDTO) {
//        System.out.println("rgsMemDTO = " + rgsMemDTO);
        rgsMemService.save(rgsMemDTO);
        return "rgsLogin";
    }
}
