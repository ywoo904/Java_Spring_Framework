package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerock.command.ScoreVO;
import com.zerock.service.ScoreService;
import com.zerock.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service/*")
public interface ScoreServiceController {

	//1.객체생성 
	ScoreService scoreService = new ScoreServiceImpl() 
	
		
	
	
	
	
	//점수등록 화면처리
	@RequestMapping("/1scoreRegister")
	public String score() { 
		return "service/1scoreRegister";
	}
	
	//점수등록메서드
	@RequestMapping("scoreForm")
	public String scoreForm(ScoreVO vo) { 
		scoreService.scoreRegist(vo);//점수등록진행 
		
		
		return "service/2scoreResult"; 
	} 
	
	//점수리스트  
	@RequestMapping("/3scoreList")
	public String scoreList(Model model) {
		
		ArrayList<ScoreVo> scorelist= scoreService.scoreResult();
		model.addAttribute("scorelist",scorelist); 
		
		return "service/3scoreResult";
		
	} 
	
	
	
	
	
	
}
