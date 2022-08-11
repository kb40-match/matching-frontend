package com.matching.kb40.backend.controller;

import com.matching.kb40.backend.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.backend.dto.ChatDto;
import com.matching.kb40.backend.model.Chatting;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class ChattingController {
	
	@Autowired
	private ChattingService chattingService;

    @GetMapping("/chatting")
    public ResponseEntity<ChatDto> getChattingSample() {
		Chatting chatting = chattingService.chattingTest();
    	log.info("Chatting : {}", chatting);

		ChatDto ChatDto = new ChatDto();
//		ChatDto.setSampleData(chatting.getSampleData());
    	
    	return new ResponseEntity<>(ChatDto, HttpStatus.OK);
    }
}
