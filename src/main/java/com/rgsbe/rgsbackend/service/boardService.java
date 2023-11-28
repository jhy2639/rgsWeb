package com.rgsbe.rgsbackend.service;

import com.rgsbe.rgsbackend.repository.boardRepository;
import com.rgsbe.rgsbackend.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class boardService {

    @Autowired
    private boardRepository boardRepository;

    // 글작성
    public void write(Board board, MultipartFile file) throws Exception{

        // 저장경로 설정
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        // 식별자
        UUID uuid = UUID.randomUUID();

        // 식별자 + _ + 파일이름
        String filename = uuid + "_" + file.getOriginalFilename();

        // File saveFile = new File(경로, "저장될이름");
        // 파일생성
        File saveFile = new File(projectPath, filename);
        file.transferTo(saveFile);

        board.setFilename(filename);
        board.setFilepath("/files/" + filename);

        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);

    }

    public Page<Board> boardSearchList(String searchKeyWord, Pageable pageable){

        return boardRepository.findByTitleContaining(searchKeyWord, pageable);
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }
}