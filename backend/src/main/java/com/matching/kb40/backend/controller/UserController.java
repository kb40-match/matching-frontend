package com.matching.kb40.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.backend.dto.UserDto;
import com.matching.kb40.backend.model.User;
import com.matching.kb40.backend.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 다른 Restful 어노테이션들
	 * @PutMapping
	 * @PostMapping
	 * @DeleteMapping
	 * 
	 * 
	 * */
    
    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserSample() {
		User user = userService.userTest();
    	log.info("User : {}", user);

		UserDto userDto = new UserDto();
		userDto.setSampleData(user.getSampleData());
    	
    	return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
