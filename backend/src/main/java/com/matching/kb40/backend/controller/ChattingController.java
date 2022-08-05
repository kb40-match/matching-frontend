package com.matching.kb40.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.backend.dto.ChattingDto;
import com.matching.kb40.backend.model.Chatting;
import com.matching.kb40.backend.service.ChattingService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class ChattingController {
	
	@Autowired
	private ChattingService chattingService;

	/**
	 * 다른 Restful 어노테이션들
	 * @PutMapping
	 * @PostMapping
	 * @DeleteMapping
	 * 
	 * 
	 * */
    
    @GetMapping("/chatting")
    public ResponseEntity<ChattingDto> getChattingSample() {
		Chatting chatting = chattingService.chattingTest();
    	log.info("Chatting : {}", chatting);

		ChattingDto chattingDto = new ChattingDto();
		chattingDto.setSampleData(chatting.getSampleData());
    	
    	return new ResponseEntity<>(chattingDto, HttpStatus.OK);
    }
}
