package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    public List<QuestionDto> findAll() throws Exception;
}
