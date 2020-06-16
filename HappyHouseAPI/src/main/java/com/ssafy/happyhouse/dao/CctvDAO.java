package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.cctv;

public interface CctvDAO {
	void regist(String roadName,String lat,String lon);
	List<cctv> list();
	List<cctv> search(String name);
}
