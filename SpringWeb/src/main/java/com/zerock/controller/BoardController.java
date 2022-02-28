package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;
import com.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	//1. Controller 구현(뷰작업)
	//2. 테이블 생성(더미 데이터 작업)
	/*
	 	create table tbl_board(
    	num int default tbl_board_seq.nextval primary key,
    	title varchar(200) not null,
    	content varchar(2000) not null,
    	writer varchar(50) not null,
    	regdate timestamp default sysdate,
    	updatedate timestamp default sysdate
		);
	 */
	//3. DB관련 설정테스트(root-context.xml 작업 후 테스트)
	//4. BoardVO 생성(DB의 컬럼명으로 동일하게 생성)
	//5. Service 구현
	//6. DAO 구현
	
	@Autowired
	private BoardService service;
	
	//get방식
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(@ModelAttribute("cri") Criteria cri) {   //페이징 작업... 
		System.out.println("등록화면처리");
	
		
		return "board/register";
	}
	
	//post방식
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo) {
		System.out.println("등록처리");
		//서비스처리..
		service.register(vo);
		return "redirect:/board/list";
	}
	
	//게시글 리스트
//	@RequestMapping("/list")
//	public String list(Model model) {
//		//list에 요청이 들어오면 db에서 모든값을 가지고 화면으로 이동해야한다.
//		ArrayList<BoardVO> list = service.getList();
//		//컨트롤러 메서드의 리턴값 추가하고 싶다면..
//		//1. model객체를 추가
//		//2. 리턴 유형을 ModelAndView객체를 추가
//		model.addAttribute("boardlist",list);
//		
//		return "board/list";
//	}
	
	//상세보기처리
	@RequestMapping("/content") 
	public String content(@RequestParam("num") int num, Model model,
			@ModelAttribute("cri") Criteria cri) { //8. 페이징에서 추가함.(이후 content.jsp를 변경함) 
		System.out.println("====컨트롤러계층===="); 
		System.out.println(num); //content.jsp에서 번호를 잘 받고 있는지 확인 
		
		BoardVO vo = service.getContent(num); 
		model.addAttribute("board", vo);
		
		return "board/content"; 
	} 
	
	//게시물수정 
	@RequestMapping("/modify") 
	public String modify(@RequestParam("num") int num, Model model,
			@ModelAttribute("cri") Criteria cri	) { 
		
		BoardVO vo= service.getContent(num);
		model.addAttribute("board", vo); 
		
		return "board/modify";
		
	} 
	
	//게시물수정완료 
	@RequestMapping("/update")
	public String update(BoardVO vo, Model model) { 
		System.out.println("------컨트롤계층------"); 
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		
		service.update(vo);
		
		model.addAttribute("update", vo); 
		
	//문제: 
	//1. Service계층에 전달받은 폼값을 전달하는 update(vo)를 생성하세
	//2. update () 메서드 안에서 myBatis로 연결하는 BoardUpdate(vo) 메서드를생성해요
	// 동작하여 업데이트 진행하세요
			
		return "redirect:/board/list"; 
	}
	
	//게시물삭제
	@RequestMapping("/delete") 
	public String delete(@RequestParam("num") int num , Model model,
			@ModelAttribute("cri") Criteria cri) { 
				       //홈페이지에서 받아 int num으로 처리해라
		System.out.println("==컨트롤계층==");
		System.out.println(num);
		//1. service계층에 num을 전달받아 처리하는 
		//delete()를 생성
		//2. MapperInterface에 void deleteBoard()를 선언
		//3. Service안에 mapper에 선언된 deleteBoard를 실행
		//4. mapper.xml; 
		service.delete(num);
	
		
		return "redirect:/board/list";
		
	} 
	
	//페이징화면처리
	@RequestMapping("/list")
	public String list (Model model, Criteria cri) { 
		
		//게시글정보가져오기(Criteria로 기준설정) 
		ArrayList<BoardVO> list= service.getList(cri);
		
		model.addAttribute("boardlist",list);
	
		//게시글 전체 데이터를 가져오기 
		int total= service.getTotal();
		//PageVO(페이징 기준, 전체 게시글 개수)를 전달하면 PageVO에서는 페이징에 대한 계싼을 모두 끝냄
		model.addAttribute("pageMaker",new PageVO(total, cri));
		
		return "board/list"; 
	} 
	
	
	
	
	
	
	
	
	
	
}
