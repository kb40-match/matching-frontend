package com.matching.kb40.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDto {
    private Long questionId;          // auto_increment
    private String questionContent;
    private String answerContent1;
    private String answerContent2;
    private String userDataColName;
}
