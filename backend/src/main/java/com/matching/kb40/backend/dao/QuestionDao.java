package com.matching.kb40.backend.dao;

import com.matching.kb40.backend.dto.QuestionDto;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDao {

    public List<QuestionDto> retrieveAll() throws SQLException;
}
