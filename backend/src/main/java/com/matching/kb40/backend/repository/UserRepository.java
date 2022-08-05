package com.matching.kb40.backend.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matching.kb40.backend.model.User;

@Repository
public class UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
	SqlSessionTemplate userSqlSessionTemplate;

    public User userTest() {
		int sampleData = userSqlSessionTemplate.selectOne("user.userTest");
		User user = new User();
		user.setSampleData(sampleData);
		
		logger.debug("User >>>>>>>" + user.toString());

		return user;
	}
}
