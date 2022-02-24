package com.zerock.batistest;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.mapper.ScoreMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Insert {

	@Autowired
	ScoreMapper mapper;
	
	@Test 
	public void insert() {   
		ScoreVO vo= new ScoreVO(); 
		try { 
		vo.setName("우영현");
		vo.setKor("100");
		vo.setEng("100");
		vo.setMath("100");
		boolean result= mapper.insert(vo);
		System.out.println("성공이면'True'출력, 아니면'False':"+result);
		
		} catch (Exception e) {  
			e.printStackTrace();
		}
	} 
	
	/*
	@Test 
	public void insert2() {   
		
		try { 
			Map<String,String> map = new HashMap<>(); 
			map.put("p1","홍길자");
			map.put("p2","80");
			map.put("p3","80");
			map.put("p4","80");
	
		
		boolean result= mapper.insert2(map);
		System.out.println("map을 이용한 mybatis 성공?:"+result);
		
		} catch (Exception e) {  
			e.printStackTrace();
		}
		
	} 
	
	*/
	
	
	
	
	
	
	
}
