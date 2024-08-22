package com.jung.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	
	
	
	@GetMapping("/ajax/person")
	@ResponseBody
	// Response에 데이터(JSON)를 담는 페이지
	// API (response에 json이 담겨있다고 생각 이형태를(AJAX) API라고 함)
	// 이름과 생년월일 전달 받고, 이름과 나이를 json 으로 response 담는 기능
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday){
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2024 - year + 1;
		
		// {"name" : "김인규", "age":24} response에 담는건 결국 문자열이다.(이게 중요)
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
	}
	
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		return "ajax/ex01";
	}
	
	
	
}
