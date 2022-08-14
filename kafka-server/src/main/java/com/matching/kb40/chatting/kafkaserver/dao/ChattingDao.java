package com.matching.kb40.chatting.kafkaserver.dao;

import java.sql.SQLException;

import com.matching.kb40.chatting.kafkaserver.dto.ChatDto;
import com.matching.kb40.chatting.kafkaserver.model.ReadChat;

public interface ChattingDao {

    public int insertChat(ChatDto chatDto) throws SQLException;

    public int updateChat(ReadChat readChat) throws SQLException;
}
