package com.matching.kb40.chatting.chattingserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReadChat {
    private Long matchId;
    private String userId;
}
