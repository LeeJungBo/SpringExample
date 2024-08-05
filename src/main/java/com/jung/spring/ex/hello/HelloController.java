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
	
	
	

}
