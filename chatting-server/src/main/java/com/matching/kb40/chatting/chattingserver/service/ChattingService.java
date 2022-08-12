package com.matching.kb40.chatting.chattingserver.service;

import org.springframework.kafka.support.Acknowledgment;

public interface ChattingService {

	public void  receiveChat(String message, Acknowledgment ack) throws Exception;

    public void  updateChat(String message, Acknowledgment ack) throws Exception;

}
