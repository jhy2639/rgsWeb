package com.rgsbe.rgsbackend.repository;

import com.rgsbe.rgsbackend.entity.t_board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface t_boardRepository extends JpaRepository<t_board, Integer> {

}
