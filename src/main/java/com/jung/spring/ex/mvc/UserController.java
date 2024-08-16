package com.jung.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jung.spring.ex.mvc.domain.User;
import com.jung.spring.ex.mvc.service.UserService;




@RequestMapping("/mvc/user")
@Controller
public class UserController {
	// HTML에 담는거여서 타입 String
	
	@Autowired
	private UserService userService;
	
	// 사용자 정보 저장 기능
	@PostMapping("/create")
	public String createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday // 여기에서 어떻게 이름을 하든 아무 상관이 없다 단순히 전달받는 역할만 하는거니 쿼리이름하고 아무 상관없어
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			, Model model){
				
	 // int count = userService.addUser(name, birthday, email, introduce);
				
				User user = new User();
				user.setName(name);
				user.setYyyymmdd(birthday);
				user.setEmail(email);
				user.setIntroduce(introduce);
				
				userService.addUserByObject(user); // 이거 같은 경우에는 바로 객체를 그냥 화면에다가 바로 띄워버리는거
												   // @RequestParam을 통해서 하는거랑 다른점은 Request는 하나하나 파라미터를 받고 나중에 모든 결과를 
				model.addAttribute("result",user); // 밑에 있는 public String userInfo(Model model)메소드를 한번더 거치고 가는거 따라서 둘은 완전히 다른 방법임
				return "mvc/userInfo";
				
		//return "redirect:/mvc/user/info";
		
	}
	
	// 입력 화면 페이지
	@GetMapping("/input") // 그냥 입력페이지만 만들어주는거고 입력받는 parameter가 없으니 Getmapping
	public String userInput() {
		return "mvc/userInput"; // @GetMapping("/input") 여기에서의 input과는 전혀 관련이 없음
	}
	
	
	
	
	
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET) 이런것들이 생략되어있던것들
	@GetMapping("/info")// get메소드를 기반으로 하는것 나중에는 이건 post등 결정해줘야함
	public String userInfo(Model model) {// 모델 객체를 만들어준다
		
		User user = userService.getLastUser();
		
		model.addAttribute("result", user); // user 실제 객체는 이거고 (키, 밸류 형태로 두는거)
		model.addAttribute("title", "회원정보"); 
		
		return "mvc/userInfo"; // 경로를 해주는거고 responseBody해줄필요없음 Html로 보내주기 위해
		
	}
	
	
	
	
	
	
}
