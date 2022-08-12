package com.matching.kb40.chatting.chattingserver.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.matching.kb40.chatting.chattingserver.dto.ChatDto;
import com.matching.kb40.chatting.chattingserver.model.ReadChat;

public interface ChattingDao {

    public int insertChat(ChatDto chatDto) throws SQLException;

    public int updateChat(ReadChat readChat) throws SQLException;
}
