package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.QuestionDao;
import com.matching.kb40.backend.dto.QuestionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
	private QuestionDao questionDao;

	@Override
	public List<QuestionDto> findAll() throws Exception {
		return questionDao.retrieveAll();
	}
}
