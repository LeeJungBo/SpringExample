package com.jung.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.mybatis.domain.Review;
import com.jung.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	// Parameter로 전달 받은 id와 일치하는 리뷰 정보를 json으로 Response 담는다.
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id){//int id의 id 변수는 이름 맘데로 해도됨 '(@RequestParam("id")'이건 사용법 무조건 이렇게 써줘야함 int id는 그냥 표시만 해준거
		// request Parameter						 // servlet은 PareInt 해주고 해야됐지만 스프링은 알아서 저 int id 의 int에 맞춰서 변형해줘서 집어넣어
		// request.getParameter("id");
		
		
		
		Review review = reviewService.getReview(id);
		
		return review;
		
	}

}
