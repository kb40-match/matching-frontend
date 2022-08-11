package com.matching.kb40.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MatchDto {
    private Long matchId;   // auto_increment
    private String sender;
    private String receiver;
    private String activeFlag;
}
