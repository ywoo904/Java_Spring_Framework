package com.zerock.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.member.command.MemberVO;
import com.zerock.member.service.MemberService;

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
	
	@Autowired
	private MemberService service;
	
	//로그인 처리
	@RequestMapping("/login")
	public String login() {  
		return "member/login";
		
	} 
	//회원가입처리
	@RequestMapping("/join")
	public String join() {  
		System.out.println("등록");
		
		
		return "member/join";
		
	} 
	
	//회원가입처리 JoinForm 처리 
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, 
			RedirectAttributes RA ) {  
	
		//서비스로 join을 처리해야함.
		int result = service.join(vo);
	
		if(result==1) {  //1반환시 성공 
			RA.addFlashAttribute("msg","회원가입에 성공했습니다.");
		} else { //insert 실패 
			RA.addFlashAttribute("msg","회원가입에 실패했습니다.");
		}
		
		return "redirect:/member/join_result";  //login 컨트롤러로
	}
	
	//회원가입 확인처리
	@RequestMapping("/join_result")
	public String join_result() { 
	
		return "member/login";
		
	} 
	
	//로그인폼처리 - 인증, 세션, 성공? => "/", 실패? => "login"
	@RequestMapping("/loginForm")
	public String loginForm(MemberVO vo, 
			HttpSession session,
			RedirectAttributes RA) {
		
		int result= service.login(vo);
		System.out.println(result);
		
		if (result==1) { //1개의 카운트 나왔다는 것으로 로그인 성공
			//세션생성
			session.setAttribute("user_id", vo.getId());
		
			
			return "redirect:/"; //home컨트롤러의 ㄷ매핑으로
		
		} else { //로그인 실패 
			RA.addFlashAttribute("msg","아이디 비밀번호를 확인하세요");
		
			return "redirect:/member/login";
			
		} 
		
		
		
	}  
	
	//로그아웃 
	@RequestMapping("/logout") 
	public String logout(HttpSession session) { 
		session.invalidate();
		
		
		return "redirect:/";
	} 
	
	
	//AJAX 테스트에 접속 
	@RequestMapping("/ajax_test")
	public String test() {  
		
		return "member/ajax_test"; 
	}
	
	//아이디 중복확인처리
	@RequestMapping("/checkId") 
	@ResponseBody
	public int CheckId(@RequestParam("id") String id) {  
		int result = service.checkId(id); 
		
		return result; 
		
	}
	
	
}
