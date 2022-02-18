package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;

//@Component  //잘됨
//@Component("scoreService")   //잘됨
//@Repository  //잘됨

//@Service
@Service("scoreService")  //해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
public class ScoreServiceImpl implements ScoreService {

	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
	
	@Override
	public void scoreRegist(ScoreVO dao) {
		
		System.out.println("-------- 서비스 계층 ---------");
		System.out.println(dao.getName());
		System.out.println(dao.getKor());
		System.out.println(dao.getEng());
		System.out.println(dao.getMath());
		
		list.add(dao);
		
		System.out.println(list.toString());	
	
	}

	@Override
	public ArrayList<ScoreVO> scoreResult() {
		return list;
	}

	@Override
	public void scoreDelete(String number) {
		
		int num = Integer.parseInt(number);
		list.remove(num);

	}

}
