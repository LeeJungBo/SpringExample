package com.jung.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jung.spring.ex.mvc.domain.User;
import com.jung.spring.ex.mvc.service.UserService;

@Controller
public class UserController {
	// HTML에 담는거여서 타입 String
	
	@Autowired
	private UserService userService;
	
	
	
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET) 이런것들이 생략되어있던것들
	@GetMapping("/mvc/user/info")// get메소드를 기반으로 하는것 나중에는 이건 post등 결정해줘야함
	public String userInfo(Model model) {// 모델 객체를 만들어준다
		
		User user = userService.getLastUser();
		
		model.addAttribute("result", user); // user 실제 객체는 이거고 (키, 밸류 형태로 두는거)
		model.addAttribute("title", "회원정보"); 
		
		return "mvc/userInfo"; // 경로를 해주는거고 responseBody해줄필요없음 Html로 보내주기 위해
		
	}
	
	
	
	
	
	
}
