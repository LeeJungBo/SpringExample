package com.jung.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	@ResponseBody
	@RequestMapping("/hello")//유아러맵핑과 비슷
	public String hello() {
		return "Hello World!!";
	}
	//클래스 하나에 여러페이지를 만들수있다(여러 메소드를 유아러 맵픽가능)
	//response에는 문자열로 담기는거다(기억해줄것)
	
	

}
