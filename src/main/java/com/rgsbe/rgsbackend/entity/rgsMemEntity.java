package com.rgsbe.rgsbackend.entity;

import com.rgsbe.rgsbackend.dto.rgsMemDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "rgsmember")
public class rgsMemEntity {
    @Id //PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regNo;
    @Column(unique = true)
    private String memID;
    @Column
    private String memPwd;
    @Column
    private String memNm;
    @Column
    private String memPhone;
    @Column
    private String memBirth;

    public static rgsMemEntity toRgsMemEntity(rgsMemDTO rgsMemDTO) {
        rgsMemEntity rgsMemEntity = new rgsMemEntity();

        rgsMemEntity.setMemID(rgsMemDTO.getMemID());
        rgsMemEntity.setMemPwd(rgsMemDTO.getMemPwd());
        rgsMemEntity.setMemNm(rgsMemDTO.getMemNm());
        rgsMemEntity.setMemBirth(rgsMemDTO.getMemBirth());
        rgsMemEntity.setMemPhone(rgsMemDTO.getMemPhone());
        return rgsMemEntity;
    }
}