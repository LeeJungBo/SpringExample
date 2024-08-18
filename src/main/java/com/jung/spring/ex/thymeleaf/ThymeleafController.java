package com.jung.spring.ex.thymeleaf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
	
	@GetMapping("ex01") // 파라미터 없어서 get멥핑
	public String ex01() {
		return "thymeleaf/ex01";
	}
	
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		
		// 서비스까지 가기엔 일단 번거로우니 여기다가 리스트 객체 만들어보기
		// 과일 이름 리스트
		List<String> fruitList = new ArrayList<>();
		
		fruitList.add("사과");
		fruitList.add("귤");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		// "name : 이중보, "age" : 29, "hobby" : 독서
		// "name : 바다, "age" : 5, "hobby" : 사냥하기 (이런 한사람의 정보를 묶어서 관리 map으로 묶기)
		
		List<Map<String,Object>> userList = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "김인규");
		userMap.put("age", 29);
		userMap.put("hobby", "독서");
		
		userList.add(userMap);
		
		userMap = new HashMap<>();
		userMap.put("name", "바다");
		userMap.put("age", 5);
		userMap.put("hobby", "사냥하기");
		
		userList.add(userMap);
		
		model.addAttribute("userList", userList);
		
		return "thymeleaf/ex02";
		
	}
	
	
	
	
}
