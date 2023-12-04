package com.rgsbe.rgsbackend.repository;

import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rgsMemRepository extends JpaRepository<rgsMemEntity, Integer> {

}
