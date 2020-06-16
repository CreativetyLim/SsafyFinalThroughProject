package com.ssafy.happyhouse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootTest
class HappyHouseApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@RequestMapping("local")
	String home() {
		return "Sex";
	}

}
