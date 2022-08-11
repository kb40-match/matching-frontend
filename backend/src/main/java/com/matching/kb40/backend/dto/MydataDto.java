package com.matching.kb40.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MydataDto {
    private String mydataId;
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
