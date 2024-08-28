package com.jung.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private UserService userService; // 이미 mvc패키지에 만들어져 있음
	
	
	// 사용자 추가 API(어쨋든 response에 데이터를 담아야한다)형태로 써보자
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
			int count = userService.addUser(name, birthday, email, introduce);
			
			// 성공, 실패(일단 됐는지 안됐는지만 봐보자
			// {"result":"success"} 성공했으면 result에다가 success 담고
			// {"result":"fail"}
			Map<String, String> resultMap = new HashMap<>();
			if(count == 1) {
				// 성공
				resultMap.put("result", "success");
			}else {
				// 실패
				resultMap.put("result", "fail");
			}
			
			return resultMap;
	}
	
	// 사용자 입력 View // 데이터를 제이슨형태로 담아 리스폰에 전달하는거 API
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	// 전달받은 이메일주소가 이미 저장된 주소인지 알려주는 API
	// email 중복확인 API
	@GetMapping("/duplicate-email")
	@ResponseBody
	public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email) {
		boolean isDuplicate = userService.isDuplicateEmail(email);
		Map<String, Boolean> resultMap = new HashMap<>();
		// {"isDuplicate":true}
		// {"isDuplicate":false}	이 형태의 문자열 json을 만들자
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		}else {
			resultMap.put("isDuplicate", false);
		}
		return resultMap;
	}
	
	
}
