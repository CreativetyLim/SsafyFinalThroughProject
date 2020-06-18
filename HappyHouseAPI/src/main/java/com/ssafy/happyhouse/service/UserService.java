package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.User;

public interface UserService {
//	회원 등록
	int register(User user);
//	회원정보 수정
	int update(User user);
//	회원정보 삭제
	int delete(String uId);
//	로그인
	int login(User user);
}
