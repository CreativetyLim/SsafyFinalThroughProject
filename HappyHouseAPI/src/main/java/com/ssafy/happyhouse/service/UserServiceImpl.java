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
	public int register(User user) {
		System.out.println("Servicesss");
		return userDAO.register(user);
	}

	@Override
	public int update(User user) {
		return userDAO.register(user);
	}

	@Override
	public int delete(String uId) {
		return userDAO.delete(uId);
	}

	@Override
	public int login(User user) {
		return userDAO.login(user);
	}

}
