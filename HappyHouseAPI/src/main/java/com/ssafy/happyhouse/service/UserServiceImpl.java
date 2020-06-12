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
	public void Register(User user) {
		userDAO.register(user);
	}

	@Override
	public int idCheck(String uId) {
		return userDAO.idCheck(uId);
	}

}
