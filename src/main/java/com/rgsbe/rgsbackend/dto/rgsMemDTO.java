package com.rgsbe.rgsbackend.dto;

import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class rgsMemDTO {
    private Integer regNo;
    private String memID;
    private String memPwd;
    private String memNm;
    private String memBirth;
    private String memPhone;

    public static rgsMemDTO toRgsMemDTO(rgsMemEntity rgsmemEntity){

        if(rgsmemEntity == null){
            return null;
        }

        rgsMemDTO rgsMemDTO = new rgsMemDTO();
        rgsMemDTO.setMemID(rgsmemEntity.getMemID());
        rgsMemDTO.setMemPwd(rgsmemEntity.getMemPwd());
        rgsMemDTO.setMemNm(rgsmemEntity.getMemNm());
        rgsMemDTO.setMemBirth(rgsmemEntity.getMemBirth());
        rgsMemDTO.setMemPhone(rgsmemEntity.getMemPhone());
        return rgsMemDTO;
    }
}