package com.matching.kb40.backend.service;

import com.matching.kb40.backend.dao.UserDao;
import com.matching.kb40.backend.dto.MydataDto;
import com.matching.kb40.backend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
	private UserDao userDao;

	@Override
	public UserDto find(String userId) throws Exception {
		return userDao.retrieve(userId);
	}

	@Override
	public List<UserDto> findAll() throws Exception {
		return userDao.retrieveAll();
	}

	@Override
	public void modify(UserDto user) throws Exception {
		userDao.update(user);
	}

	@Override
	public void remove(String userId) throws Exception {
		userDao.delete(userId);
	}

	@Override
	public MydataDto findMydata(String userId) throws Exception {
		return userDao.retrieveMydata(userId);
	}
}
