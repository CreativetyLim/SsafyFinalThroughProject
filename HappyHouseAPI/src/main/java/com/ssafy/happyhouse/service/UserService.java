package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.User;

public interface UserService {
//	회원 등록
	void Register(User user);
//	아이디 중복 확인
	int idCheck(String uId);

}
