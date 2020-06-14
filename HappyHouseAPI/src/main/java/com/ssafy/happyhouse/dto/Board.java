package com.ssafy.happyhouse.dto;

import java.util.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardUserid;
	private Date boardDatetime;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUserid() {
		return boardUserid;
	}
	public void setBoardUserid(String boardUserid) {
		this.boardUserid = boardUserid;
	}
	public Date getBoardDatetime() {
		return boardDatetime;
	}
	public void setBoardDatetime(Date boardDatetime) {
		this.boardDatetime = boardDatetime;
	} 
	
	
	
}
