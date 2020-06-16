
package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	List<QnA> retrieveQnA();
	int regist(String qna_userid,String qna_title,String qna_content);
	int registReply(int no,String replyUserid,String replyContent);
	public int update(int no,String qna_userid,String qna_title,String qna_content);
	public int delete(int no);
	public int deleteReply(int no);
	public List<QnA> selectOne(String search);
}
