package com.matching.kb40.chatting.chattingserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatDto {
    private Long chatId;           // auto_increment
    private Long matchId;
    private String userId;
    private String content;
    private String readFlag;
    private String createdDate;
}
