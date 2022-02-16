package src.test.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	//화면처리 
	@RequestMapping("/member_ex01") 
	public String member_ex01() { 
		
		return "service_member_ex01";
		
	}
	
	
	
}
