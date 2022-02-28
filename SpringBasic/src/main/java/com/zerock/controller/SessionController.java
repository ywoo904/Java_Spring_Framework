package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
}
