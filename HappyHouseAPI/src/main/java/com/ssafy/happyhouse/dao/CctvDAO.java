package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.cctv;

@Mapper
public interface CctvDAO {
	void regist(String roadName,String lat,String lon);
	List<cctv> list();
	List<cctv> search(String name);
}
