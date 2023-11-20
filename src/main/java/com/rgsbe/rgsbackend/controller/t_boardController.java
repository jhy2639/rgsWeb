package com.rgsbe.rgsbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class t_boardController {

    @GetMapping("/t_board/write") //localhost:8090/t_board/write
    public String t_boardWriteForm(){
        return "t_boardWrite";
    }
}
