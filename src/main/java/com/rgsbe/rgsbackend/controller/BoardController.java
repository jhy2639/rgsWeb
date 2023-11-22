package com.rgsbe.rgsbackend.controller;

import com.rgsbe.rgsbackend.entity.Board;
import com.rgsbe.rgsbackend.service.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private boardService boardService;

    @GetMapping("/board/write") //localhost:8090/board/write
    public String t_boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String writedoProcess(Board board){

        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8090/board/view?id=1
    public String t_boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }
}
