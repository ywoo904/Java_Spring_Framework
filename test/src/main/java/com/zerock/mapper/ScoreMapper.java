package com.zerock.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.ScoreVO;

public interface ScoreMapper {

	public boolean insert(ScoreVO vo); 
	public ArrayList<ScoreVO> select (); 
	public void delete(String num);	
	
}
