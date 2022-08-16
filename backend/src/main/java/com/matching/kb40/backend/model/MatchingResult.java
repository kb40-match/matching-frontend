package com.matching.kb40.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MatchingResult {
    private Integer num;
    private String userId;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private Long assets;
    private String consumePtn1;
    private String consumePtn2;
    private String consumePtn3;
    private String investProp;
    private String job;
    private String mbtiMind;
    private String mbtiRecog;
    private String mbtiJudge;
    private String mbtiTactics;
    private String profileFilename;
    private Long userPoint;
    private String petPrefer;
    private String nickname;
    private String agreeFlag;
    private String hobby;
    private Integer fitPercent;
}
