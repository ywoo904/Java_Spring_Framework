package com.zerock.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.member.command.MemberVO;
import com.zerock.member.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired //mybatis 매퍼를 추가
	private MemberMapper mapper; 
	
	@Override
	public int checkId(String id)  { 
		
		int result = mapper.checkId(id); 
		System.out.println("성공실패?"+result);
		
		return result; 
	}
	
	
	@Override
	public int join(MemberVO vo) {
		//mapper를 생성(MemberMapper)한 후에 DB와 마이바티스로 연동처리
		//처리된 결과를 확인반환값으로 넘김
		//마이바티스는 root-xontext.xml에서 xml스캔처리 해야함 
		//xml에는 쿼리에 대한 내용이 정리되어야 한다. 
		int result=mapper.join(vo);
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
	
		
		return result;
	}
	
	@Override
	public int login(MemberVO vo) {
		int result= mapper.login(vo); 
		//1. mapper생성, 이후 DB와 MyBatis이용하여 연동 
		//2. 처리된 결과를 반환값으로 넘김 
		//3. XML 쿼리값 처리
		

		return result;
	}
	
	
	
	
	
	
	
}
