package com.zerock.board.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.mapper.BoardMapper;

//Service
//스프링에서 DispatcherServlet이 동작하고, 핸들러어댑터가 가동되면, 해당 어노테이션확인
//빈으로 등록 생성.
//수동으로 bean등록을 하지 않았고, 어노테이션을 사용했다면 servlet-context에서 conponent 스캔을 해야한다.
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	//게시글리스트 
	/*
	 * @Override public ArrayList<BoardVO> getList() { ArrayList<BoardVO> list =
	 * mapper.getList(); return list; }
	 */
	
	//페이징게시글리스트
	@Override 
	public ArrayList<BoardVO> getList(Criteria cri){ 
	
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		return list; 
	} 

	
	//전체게시물수 
	@Override
	public int getTotal() { 
		int total= mapper.getTotal(); 
		return total;
	}

	
	@Override
	public void register(BoardVO vo) {
		//등록처리..
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		mapper.insertBoard(vo);
	}

	@Override
	public BoardVO getContent(int num) {

	BoardVO vo=mapper.getContent(num);
	System.out.println("================");
	System.out.println(vo.getTitle());
	System.out.println(vo.getContent());
	System.out.println(vo.getWriter());
		return vo; 
	
	}

	@Override
	public void update(BoardVO vo) {
		
	boolean bool= mapper.updateBoard(vo);
	System.out.println("성공실패?:"+bool);
	}

	@Override
	public void delete(int num) {
	
	 mapper.deleteBoard(num);
	 
	
	}
	
	
	
	

}
