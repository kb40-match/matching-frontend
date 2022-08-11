package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.ChattingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.kb40.backend.model.Chatting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChattingServiceImpl implements ChattingService{
    @Autowired
	private ChattingDao chattingDao;

	@Override
	public Chatting chattingTest(){
		return chattingDao.chattingTest();
	}
}
