package com.zerock.member.mapper;


import com.zerock.member.command.MemberVO;

public interface MemberMapper {
	
	public int checkId(String id); //아이디 중복확인
	public int join(MemberVO vo);//회원가입
	public int login(MemberVO vo);//로그인
	
	
	
	
}
