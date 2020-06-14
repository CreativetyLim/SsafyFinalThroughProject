package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.User;

public interface UserService {
//	회원 등록
	int Register(User user);
//	아이디 중복 확인
	int idCheck(String uId);
//	회원정보 수정
	int update(User user);
//	회원정보 삭제
	int delete(String uId);
//	로그인
	User login(User user);
}
