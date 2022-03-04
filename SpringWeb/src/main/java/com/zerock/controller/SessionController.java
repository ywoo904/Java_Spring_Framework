package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	

	//1. main화면 처리(mainPage) 
	@RequestMapping("/mainPage")
	public String mainPage() {  
		return "session/mainPage";
		
	} 
	
	//2. 로그인 -> loginPage 
	@RequestMapping("/loginPage") 
	public String loginPage() {  
		
		return "session/loginPage";
	}
	
	//3. 마이페이지 화면처리 -> 마이페이지
	@RequestMapping(value= "/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {  
		//8. 마이페이지 접근막기 
		//세션 아이디가 없다면 접근할 수 없게 로그인 페이지로 이동
	//	if (session.getAttribute("user_id")==null) { 
	//		return "redirect:/session/loginPage";
	//		
	//	} else {  
		
		return "session/myPage"; 
		
		} 
	
	//4.정보수정페이지
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage() {  
		//9.세션 아이디 없을 경우 접근 차단.. 위와 같이 모든 페이지에 이렇게. 
		//쉽게 처리하기 위해서 인터셉터를 이용. 
		/*
		 [인터셉터(Interceptor)의 요도 및 예시]
		 -세부적인 보안 미 인증/인가 공통작업
		 -API 호출에 대한 로깅 또는 검사
		 -Controller로 넘겨주는 정보(데이터)의 가공
		  */
		
		return "session/updatePage"; 
	}
	
	//5.로그인 폼처리(login정보처리)  
	@RequestMapping("/sessionLogin")
	public String sessionLogin(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session, 
			RedirectAttributes RA) {  
		//아이디가 abc, 비밀번호가 1234라면 로그인 성공
		if (id.equals("abc") && pw.equals("1234")) {
			//로그인 성공시 인증 값 생성 후 -> MyPage로 이동 
			session.setAttribute("user_id", id); //세션에 아이디를 저장
			session.setAttribute("user_name","홍길동");//세션에 이름을 저장 
			return "redirect:/session/myPage"; 
		} else {  
			//6. 아이디와 비밀번호가 틀렸을 경우 다시 로그인으로 보내기
			//9. 리다이렉트를 보내면서 1회성 데이터로 파라미터값을 전달하고자 할 때 사용 
			RA.addFlashAttribute("msg","아이디 비밀번호를 확인하시겠습니까?"); 
			return "redirect:/session/loginPage";	
		}		
	}
	
	//6. 로그아웃 
	@RequestMapping("/logout")
	public String logout(HttpSession session) {  
		session.removeAttribute("user_id"); //특정세션을 제거
		session.invalidate(); 
		return "redirect:/session/mainPage"; 
	}	
		
	}
	
	
	
