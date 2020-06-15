package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDAO;
import com.ssafy.happyhouse.dto.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	@Override
	public int Register(User user) {
		return userDAO.register(user);
	}

	@Override
	public int idCheck(String uId) {
		return userDAO.idCheck(uId);
	}

	@Override
	public int update(User user) {
		return userDAO.update(user);
	}

	@Override
	public int delete(String uId) {
		return userDAO.delete(uId);
	}

	@Override
	public User login(User user) {
		return userDAO.login(user);
	}

}
