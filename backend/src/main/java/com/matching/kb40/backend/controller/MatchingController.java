package com.matching.kb40.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.backend.dto.MatchingDto;
import com.matching.kb40.backend.model.Matching;
import com.matching.kb40.backend.service.MatchingService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class MatchingController {
	
	@Autowired
	private MatchingService matchingService;

	/**
	 * 다른 Restful 어노테이션들
	 * @PutMapping
	 * @PostMapping
	 * @DeleteMapping
	 * 
	 * 
	 * */
    
    @GetMapping("/matching")
    public ResponseEntity<MatchingDto> getMatchingSample() {
		Matching matching = matchingService.matchingTest();
    	log.info("Matching : {}", matching);

		MatchingDto matchingDto = new MatchingDto();
		matchingDto.setSampleData(matching.getSampleData());
    	
    	return new ResponseEntity<>(matchingDto, HttpStatus.OK);
    }
}
