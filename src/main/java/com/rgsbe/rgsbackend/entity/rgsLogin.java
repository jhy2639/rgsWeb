package com.rgsbe.rgsbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class rgsLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer regNo;

    private String memNm;

    private String memPhoneNum;

    private String memBirth;

    private String memID;

    private String memPwd;
}