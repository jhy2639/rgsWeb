package com.rgsbe.rgsbackend.repository;

import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface rgsMemRepository extends JpaRepository<rgsMemEntity, Integer> {
    //아이디로 회원정보 조회(select * from rgsmember where memID = ?)
    Optional<rgsMemEntity> findByMemID(String memID); // 일종의 null방지
}
