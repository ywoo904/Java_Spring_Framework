package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	//테이블 생성(id,pw,name,날짜)
	/*
	 CREATE TABLE MEMBER(   
	 	id varchar(30) primary key,
	 	pw varchar(30), 
	 	name varchar(30), 
	 	regdate timestamp default sysdate 
	  );
	 */
	
	
	@RequestMapping("/login")
	public String login() {  
		return "member/login";
		
	} 
	
	@RequestMapping("/join")
	public String join() {  
		return "member/join";
		
	} 
	
	
	
	
	
}
