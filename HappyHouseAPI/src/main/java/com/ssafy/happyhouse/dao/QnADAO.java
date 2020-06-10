package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.QnA;

@Mapper
public interface QnADAO {
	List<QnA> selectQnA();

	int regist(QnA qna);
	int registReply(QnA qna);
	public int update(QnA qna);
	public int delete(Integer qna_no);
	public int deleteReply(QnA qna);
	public List<QnA> selectOne(String search);
}
