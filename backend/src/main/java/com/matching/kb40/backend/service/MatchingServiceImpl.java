package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.MatchingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.kb40.backend.model.Matching;
import com.matching.kb40.backend.dao.MatchingDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MatchingServiceImpl implements MatchingService{

    @Autowired
	private MatchingDao matchingDao;

    /**
	 * 매칭 샘플
	 * @param 
	 * @result Match
	 */
    public Matching matchingTest() {
		return matchingDao.matchingTest();
	}
}
