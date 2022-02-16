package src.test.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.MemberVO;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	//화면처리 
	@RequestMapping("/member_ex01") 
	public String member_ex01() { 
		
		return "service/member_ex01";
	}

	@RequestMapping(value="memlogin", method=RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) { 
		
	String memid= request.getParameter("memid"); 
	String mempw= request.getParameter("mempw");	
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	}  
	
	//RequestParam 어노테이션을 이용한 HTTP 전송정보 얻기
	@RequestMapping(value="memlogin2", method=RequestMethod.POST)
	public String memlogin(Model model, 
			@RequestParam("memid") String memid,
			@RequestParam("mempw") String mempw
			) { 
		
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	
	return "service/result"; 
	
	}  
	
	//MemberVO를 이용한 vo값으로 전달받기 
	@RequestMapping(value="memlogin3", method=RequestMethod.POST)
	public String memlogin(Model model, MemberVO vo) { 
		
	String memid= vo.getId(); 
	String mempw= vo.getPw();
	String memname=vo.getName(); 
	
	model.addAttribute("memId",memid); 
	model.addAttribute("memPw",mempw); 
	model.addAttribute("memName",memname); 
	
	return "service/result"; 
		
	} 
	
	
	
}
