package com.rgsbe.rgsbackend.controller;

import com.rgsbe.rgsbackend.entity.t_board;
import com.rgsbe.rgsbackend.service.t_boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class t_boardController {

    @Autowired
    private t_boardService t_boardService;

    @GetMapping("/t_board/write") //localhost:8090/t_board/write
    public String t_boardWriteForm() {
        return "t_boardWrite";
    }

    @PostMapping("/t_board/writeProcess")
    public String writedoProcess(t_board t_board){

        t_boardService.write(t_board);
        return "";
    }

    @GetMapping("/t_board/list")
    public String boardList(Model model){

        model.addAttribute("list", t_boardService.t_boardList());

        return "t_boardList";
    }
}
