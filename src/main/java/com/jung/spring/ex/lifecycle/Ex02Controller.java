package com.jung.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	
	// 얘는 ResponseBody가 위에 쓰이면 안된다 그래야 문자열로 인식하는게 아닌 주소로 인식
	@RequestMapping("/lifecycle/ex02")//얘는 외부에서 요청하는 주소이고
	public String thymeleafEx() {
		return "lifecycle/ex02"; // 얘는 내부적으로 어느 html(출력장소)로 보내는 곳
	}
}
