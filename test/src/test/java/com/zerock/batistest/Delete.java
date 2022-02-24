package com.zerock.batistest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.mapper.ScoreMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Delete {

	@Autowired
	ScoreMapper mapper;
	
	@Test 
	public void delete() {  
		
	 mapper.delete("9");
		
		 
		}
	}
	
	

	
	
	
	
	
	
	
	

