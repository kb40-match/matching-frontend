package com.matching.kb40.backend.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matching.kb40.backend.model.Matching;

@Repository
public class MatchingDaoImpl implements MatchingDao{
    private static final Logger logger = LoggerFactory.getLogger(MatchingDaoImpl.class);

    @Autowired
	SqlSessionTemplate SqlSessionTemplate;

    public Matching matchingTest() {
		int sampleData = SqlSessionTemplate.selectOne("matching.matchingTest");
		Matching matching = new Matching();
		matching.setSampleData(sampleData);
		
//		logger.debug("Matching >>>>>>>" + matching.toString());

		return matching;
	}
}
