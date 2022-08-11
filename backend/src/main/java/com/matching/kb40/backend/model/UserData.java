package com.matching.kb40.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserData {
    private String userId;
    private String mydataId;
    private String job;
    private String mbtiMind;
    private String mbtiRecog;
    private String mbtiJudge;
    private String mbtiTactics;
    private String profileOriname;
    private String profileFilename;
    private String profileUrl;
    private Integer userPoint;
    private String petPrefer;
    private String nickname;
    private String agreeFlag;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String assets;
    private String consumePtn1;
    private String consumePtn2;
    private String consumePtn3;
    private String investProp;
}
