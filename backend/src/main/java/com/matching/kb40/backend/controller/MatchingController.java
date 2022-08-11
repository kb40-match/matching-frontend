package com.matching.kb40.backend.controller;

import com.matching.kb40.backend.dto.MatchDto;
import com.matching.kb40.backend.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.backend.model.Matching;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class MatchingController {
	
	@Autowired
	private MatchingService matchingService;

    @GetMapping("/matching")
    public ResponseEntity<MatchDto> getMatchingSample() {
		Matching matching = matchingService.matchingTest();
    	log.info("Matching : {}", matching);

		MatchDto matchDto = new MatchDto();
//		matchDto.setActiveFlag(matching.getSampleData());
    	
    	return new ResponseEntity<>(matchDto, HttpStatus.OK);
    }
}
