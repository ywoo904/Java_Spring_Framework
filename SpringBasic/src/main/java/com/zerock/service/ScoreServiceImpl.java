package com.zerock.service;

import java.util.ArrayList;

import com.zerock.command.ScoreVO;

public interface ScoreServiceImpl implements ScoreService {
	ArrayList<ScoreVO> list= new ArrayList<ScoreVO>();  
	
	@Override //시험*****
	public void scoreRegist(ScoreVO dao) {
		System.out.println("------서비스검증-------");
		System.out.println("dao.getName");
		System.out.println("dao.getKor");
		System.out.println("dao.getEng");
		System.out.println("dao.getMath");
		
		list.add(dao);
		
		System.out.println(list.toString());
		
	
	} 	
	
	@Override
	public void scoreDelete(String num) {
	
		
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {

		return null;
	}
	

	
}