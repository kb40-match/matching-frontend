package com.matching.kb40.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.kb40.backend.model.Chatting;
import com.matching.kb40.backend.repository.ChattingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChattingService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
	private ChattingRepository chattingRepository;

    /**
	 * 채팅 샘플
	 * @param 
	 * @result Chatting
	 */
    public Chatting chattingTest() {
		return chattingRepository.chattingTest();
	}
}
