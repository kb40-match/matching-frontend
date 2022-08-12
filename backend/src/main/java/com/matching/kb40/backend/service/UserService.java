package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dto.MydataDto;
import com.matching.kb40.backend.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    public UserDto find(String userId) throws Exception;

    public List<UserDto> findAll() throws Exception;

    public List<UserDto> findRandom(String gender) throws Exception;

    public void modify(UserDto user) throws Exception;

    public void remove(String userId) throws Exception;

    public MydataDto findMydata(String userId) throws Exception;
}
