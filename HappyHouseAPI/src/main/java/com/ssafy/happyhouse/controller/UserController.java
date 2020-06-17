package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.service.UserService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final Logger g = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private UserService userService;
	
//	Post방식으로 회원등록
	@PostMapping("/register")
	public int register(User user) {
		int result = userService.register(user);
		return result;
	}
	
//	회원정보 수정
	@PutMapping("/editUser")
	public int editUser(User user) {
		int result = userService.register(user);
		return result;
	}
	
//	회원정보 삭제
	@DeleteMapping("/deleteUser")
	public int deleteUser(String uId) {
		int result = userService.delete(uId);
		return result;
	}
	
//	Post 로그인
	@PostMapping("/login")
	public int login(User user, HttpServletRequest req) {
		int result = userService.login(user);
		HttpSession session = req.getSession();
		session.setAttribute("user", result);
		
		return result;
	}
	
//	Get 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	
		return "index";
	}
}
