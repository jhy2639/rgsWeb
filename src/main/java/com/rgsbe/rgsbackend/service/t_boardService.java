package com.rgsbe.rgsbackend.service;

import com.rgsbe.rgsbackend.repository.t_boardRepository;
import com.rgsbe.rgsbackend.entity.t_board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class t_boardService {

    @Autowired
    private t_boardRepository t_boardRepository;

    public void write(t_board t_board){
        t_boardRepository.save(t_board);
    }

    public List<t_board> t_boardList(){
        return t_boardRepository.findAll();
    }
}