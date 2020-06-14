package com.ssafy.happyhouse.dto;

public class User {
	private String uId;				//유저 아이디
	private String uPw;				//유저 비밀번호
	private String reuPw;			//유저 비밀번호 확인
	private String uName;			//유저 이름
	private char uGender;			//유저 성별 (F or M값만 갖는다)
	private String uTel;			//유저 전화번호
	private String uAddr;			//유저 주소
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getReuPw() {
		return reuPw;
	}
	public void setReuPw(String reuPw) {
		this.reuPw = reuPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public char getuGender() {
		return uGender;
	}
	public void setuGender(char uGender) {
		this.uGender = uGender;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
}
