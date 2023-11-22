package com.rgsbe.rgsbackend.service;

import com.rgsbe.rgsbackend.repository.boardRepository;
import com.rgsbe.rgsbackend.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class boardService {

    @Autowired
    private boardRepository boardRepository;

    // 글작성
    public void write(Board board) {
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> boardList() {
        return boardRepository.findAll();

    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }
}