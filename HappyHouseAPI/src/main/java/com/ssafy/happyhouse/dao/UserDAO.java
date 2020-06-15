package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.User;

@Mapper
public interface UserDAO {
//	회원정보 등록
	int register(User user);
//	아이디 중복 확인
	int idCheck(String uId);
//	회원정보 수정
	int update(User user);
//	회원정보 삭제
	int delete(String uId);
//	로그인
	User login(User user);
}
