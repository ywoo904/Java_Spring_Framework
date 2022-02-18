package com.zerock.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

//DAO객체주입은 일반적으로 Component나 Repository Annotation을 사용합니다.  
//Component-scan에 꼭 추가해준다. 
	
//@Component
@Repository
public class ScoreeDAOImpl implements ScoreDAO {
	
	//DB를 대신할 저장소필요(DB로 가정)  
	ArrayList<ScoreVO> DB = new ArrayList<ScoreVO>(); 
	
	@Override //점수입력메서드
	public void scoreInsert(ScoreVO vo) {
	
		System.out.println("----DAO계층---------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor()); 
		
		DB.add(vo);
		System.out.println("현재 게시물 수: " + DB.size());
	
	}
	
	
	

	@Override //점수결과 출력메서드
	public ArrayList<ScoreVO> scoreSelect() {

		return DB;
	}

	@Override //점수삭제 메서드 
	public void scoreDelete(String num) {
	
		int index = Integer.parseInt(num);
		DB.remove(index); //DB삭제
		
		
		
	}

	
	
	
	
	
	
}
