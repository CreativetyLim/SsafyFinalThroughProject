package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.User;
import com.ssafy.happyhouse.service.UserService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	Get방식으로 회원 등록
	@GetMapping("/register")
	public String register() {
		return "user";
	}
	
//	Post방식으로 회원등록
	@PostMapping("/register")
	public String register(User user) {
		userService.Register(user);
//		어디로 반환해야 할지 몰라서 일단 index로 했는데 추후에 수정하자
		return "index";
	}
	
//	Get방식으로 아이디 중복확인
	@GetMapping("/{searchid}")
	public @ResponseBody String idCheck(@PathVariable("searchid") String sid) {
		int result = userService.idCheck(sid);
		return result+"";
	}
}
