package com.rgsbe.rgsbackend.repository;

import com.rgsbe.rgsbackend.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface boardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findByTitleContaining(String searchKeyWord, Pageable pageable);
}
