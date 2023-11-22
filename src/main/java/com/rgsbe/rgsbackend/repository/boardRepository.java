package com.rgsbe.rgsbackend.repository;

import com.rgsbe.rgsbackend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface boardRepository extends JpaRepository<Board, Integer> {

}
