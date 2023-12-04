package com.rgsbe.rgsbackend.dto;

import com.rgsbe.rgsbackend.entity.rgsMemEntity;
import lombok.*;

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
}