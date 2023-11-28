package com.rgsbe.rgsbackend.controller;

import com.rgsbe.rgsbackend.entity.Board;
import com.rgsbe.rgsbackend.service.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class boardController {

    @Autowired
    private boardService boardService;

    @GetMapping("/board/write") //localhost:8090/board/write
    public String t_boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String writedoProcess(Board board, Model model, MultipartFile file) throws Exception{

        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
                            Pageable pageable,
                            String searchKeyWord) {

        Page<Board> list = null;

        if(searchKeyWord == null){
            list = boardService.boardList(pageable);
        } else {
            // 검색하는 단어가 들어왔을 때
            list = boardService.boardSearchList(searchKeyWord, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1; //Pageable이 가지는 페이지는 0에서 시작함. 처리를 위해선 1을 더해서 처리
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5 , list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8090/board/view?id=1
    public String t_boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardModify";
    }

    // Parameter 넘기는 방법 2가지
    // 1. Query String
    // 2. PathVariable
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,
                              Board board, Model model, MultipartFile file) throws Exception{

        Board boardTmp = boardService.boardView(id); // 기존의 내용가져오기

        // 기존에 있던 내용에 새로운 내용 덮어쓰기
        boardTmp.setTitle(board.getTitle());
        boardTmp.setContent(board.getContent());

        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        boardService.write(boardTmp, file);

//        return "redirect:/board/list";
        return "message";
    }
}
