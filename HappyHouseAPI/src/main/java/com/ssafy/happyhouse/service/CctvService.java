package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.cctv;

public interface CctvService {
	void regist(List<cctv> list);
	List<cctv> list();
	List<cctv> search(String name);
}