package com.zerock.member.service;

import com.zerock.member.command.MemberVO;

public interface MemberService {

	public int checkId(String id);
	public int join(MemberVO vo); //회원가입
	public int login(MemberVO vo); //회원로그인
	
	
	
	
	
	
	
}
