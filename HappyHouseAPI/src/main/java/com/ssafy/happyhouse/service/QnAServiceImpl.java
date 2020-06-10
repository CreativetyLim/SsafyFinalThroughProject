package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnADAO;
import com.ssafy.happyhouse.dto.QnA;
@Service
public class QnAServiceImpl implements QnAService {
	@Autowired
	private QnADAO dao;
	QnA qna;
	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}
	@Override
	public int regist(String qna_userid,String qna_title,String qna_content) {
		// TODO Auto-generated method stub
		qna= new QnA();
		qna.setQnaUserid(qna_userid);
		qna.setQnaTitle(qna_title);
		qna.setQnaContent(qna_content);
		return dao.regist(qna);
	}

	@Override
	public int update(int qna_no,String qna_userid,String qna_title,String qna_content) {
		qna= new QnA();
		qna.setQnaUserid(qna_userid);
		qna.setQnaTitle(qna_title);
		qna.setQnaContent(qna_content);
		qna.setQnaNo(qna_no);
		System.out.println("contents 한번 찍어보자"+qna.getQnaNo());
		return dao.update(qna);
	}

	@Override
	public int delete(int qna_no) {
		return dao.delete(qna_no);
	}

	@Override
	public List<QnA> selectOne(String search) {
		return dao.selectOne(search);
	}
	@Override
	public int registReply(int qna_no,String replyUserid,String replyContent) {
		// TODO Auto-generated method stub
		qna= new QnA();
		qna.setQnaNo(qna_no);
		qna.setReplyUserid(replyUserid);
		qna.setReplyContent(replyContent);
		return dao.registReply(qna);
	}
	@Override
	public int deleteReply(int no) {
		// TODO Auto-generated method stub
		List<QnA> list = dao.selectQnA();
		for(int i= 0; i <list.size(); i++) {
			if(list.get(i).getQnaNo() == no) {
				qna = list.get(no);
				break;
			}
		}
		qna.setReplyContent(null);
		qna.setReplyUserid(null);
		qna.setReplyDatetime(null);

		return dao.deleteReply(qna);
	}
}
