package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.MemberVO;
import com.zerock.service.MemberService;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	//인터페이스에 의존성 주입
	@Autowired
	MemberService memberService; 
	
	//로그인 입력페이지 
	@RequestMapping("/member_ex01") 
	public String member_ex01() { 
		
		return "service/member_ex01";
	}
	
	//회원가입 페이지
	@RequestMapping("/member_ex00") 
	public String member_ex00() { 
		
		
		return "service/member_ex00";
	}

	//회원가입 정상처리 페이지
	@RequestMapping("/join")
	public String join(MemberVO vo) { 
		
		memberService.insertMember(vo);
		
		return "service/member_ex02";
	}
	
	
	@RequestMapping(value="/memlogin", method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) { 
		
	String memid= request.getParameter("memid"); 
	String mempw= request.getParameter("mempw");	
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	}  
	
	//RequestParam 어노테이션을 이용한 HTTP 전송정보 얻기
	@RequestMapping(value="/memlogin2", method=RequestMethod.POST)
	public String memlogin2(Model model, 
			@RequestParam("memid") String memid,
			@RequestParam("mempw") String mempw
			) { 
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	
	}  
	
	//커멘드를 이용한 HTTP전송 정보처리(MemberVO를 이용한 vo값으로 전달받기)  
	@RequestMapping(value="/memlogin3", method=RequestMethod.POST)
	public String memlogin3(Model model, MemberVO vo) { 
	System.out.println(vo.getId());
	System.out.println(vo.getPw());
	
	model.addAttribute("memId",vo.getId()); 
	model.addAttribute("memPw",vo.getPw()); 
	model.addAttribute("memName",vo.getName()); 
	
	return "service/result"; 
		
	} 
	
	
	
	
}
