package com.jung.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//웹페이지를 구성할수있는 것으로 알아서 인식
public class Ex01Controller {
	
	@RequestMapping("/lifecycle/ex01/1")
	@ResponseBody//ResponseBody에 담을 베소드를 만든다는 의미 
	public String StringResponse() {//여기 스프링스는 알아서 http에서 String을 인식하고 아 얘는 html문자열 타입이구나라고 알아서 인식함
		return "<h1>예제 1번 문자열 담기</h1>";
	}

	@RequestMapping("/lifecycle/ex01/2")
	@ResponseBody
	public Map<String, Integer>mapResponse(){
		//과일 이름 : 가격
		
		Map<String, Integer> fruitMap = new HashMap<>();//얘는 알아서 contentType이 그냥 json으로 바로 인식하고 브라우저에 뜸
		
		fruitMap.put("apple", 1200);
		fruitMap.put("banana", 3000);
		fruitMap.put("orange", 1000);
		
		return fruitMap;
		
		}
	
}
