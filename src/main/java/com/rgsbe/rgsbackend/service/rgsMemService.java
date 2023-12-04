package com.rgsbe.rgsbackend.service;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import com.rgsbe.rgsbackend.repository.rgsMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Entity객체는 service까지만 사용
@Service
@RequiredArgsConstructor
public class rgsMemService {
    private final rgsMemRepository rgsMemRepository;
    public void memberSave(rgsMemDTO rgsMemDTO) {
        // 1.dto -> entity
        // 2.repository의 save 메소드 호출
        rgsMemEntity rgsmemEntity = rgsMemEntity.toRgsMemEntity(rgsMemDTO);
        rgsMemRepository.save(rgsmemEntity);
        //repositoty의 save 메소드 호출 (필수 조건 : entity객체를 넘겨줘야 함)
    }

    public rgsMemDTO memberLogin(rgsMemDTO rgsmemDTO) {
        /*
        * 1.회원에 입력한 아이디를 DB에서 조회
        * 2.DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호의 일치여부 확인
        * */
        Optional<rgsMemEntity> byMemID = rgsMemRepository.findByMemID(rgsmemDTO.getMemID());
        if(byMemID.isPresent()){
            System.out.println("rgsmemDTO = " + rgsmemDTO.getMemID());
            // 조회결과가 있다(해당 아이디를 가진 회원정보가 있다)
            rgsMemEntity rgsMemEntity = byMemID.get();
            if(rgsMemEntity.getMemPwd().equals(rgsmemDTO.getMemPwd())){
                System.out.println("서비스 비밀번호 같음확인");
                // 비밀번호 일치
                // entity -> dto 변환 후 return
                rgsMemDTO memDTO = rgsMemDTO.toRgsMemDTO(rgsMemEntity);
                return memDTO;
            } else {
                System.out.println("엔티티 비밀번호 : " + rgsMemEntity.getMemPwd());
                System.out.println("디티오 비밀번호 : " + rgsmemDTO.getMemPwd());
                System.out.println("서비스로그인실패");
                // 비밀번호 불일치(로그인 실패)
                return null;
            }
        } else {
            System.out.println("서비스 로그인 조회결과 없음");

            // 조회결과 없다
            return null;
        }
    }
}
