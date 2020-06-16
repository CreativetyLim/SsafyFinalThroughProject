package com.ssafy.happyhouse.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.cctv;

@Repository
public interface CctvDAO {
	void regist(String roadName,String lat,String lon);
	List<cctv> list();
	List<cctv> search(String name);
}
