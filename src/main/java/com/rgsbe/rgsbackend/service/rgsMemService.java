package com.rgsbe.rgsbackend.service;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import com.rgsbe.rgsbackend.repository.rgsMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class rgsMemService {
    private final rgsMemRepository rgsMemRepository;
    public void save(rgsMemDTO rgsMemDTO) {
        // 1.dto -> entity
        // 2.repository의 save 메소드 호출
        rgsMemEntity rgsmemEntity = rgsMemEntity.toRgsMemEntity(rgsMemDTO);
        rgsMemRepository.save(rgsmemEntity);
        //repositoty의 save 메소드 호출 (필수 조건 : entity객체를 넘겨줘야 함)
    }
}
