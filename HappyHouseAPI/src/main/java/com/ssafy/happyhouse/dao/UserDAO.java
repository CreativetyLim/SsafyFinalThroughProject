package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.User;

@Mapper
public interface UserDAO {
//	회원정보 등록
	void register(User user);
//	아이디 중복 확인
	int idCheck(String uId);
}
