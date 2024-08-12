package com.jung.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.mybatis.domain.Review;
import com.jung.spring.ex.mybatis.service.ReviewService;


@RequestMapping("/mybatis/review")
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	// Parameter로 전달 받은 id와 일치하는 리뷰 정보를 json으로 Response 담는다.
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id){//int id의 id 변수는 이름 맘데로 해도됨 '(@RequestParam("id")'이건 사용법 무조건 이렇게 써줘야함 int id는 그냥 표시만 해준거
		// request Parameter						 // servlet은 PareInt 해주고 해야됐지만 스프링은 알아서 저 int id 의 int에 맞춰서 변형해줘서 집어넣어
		// request.getParameter("id");
		
		
		
		Review review = reviewService.getReview(id);
		
		return review;
		
	}
	
	// 리뷰 정보를 저장하는 페이지
	@ResponseBody
	@RequestMapping("/create")
	public String createReview(){
		
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
		//  int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛");
		
		//2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리 입니다.
		Review review = new Review(); // R;eview클래스를 통째로 갖고 와서 이런식으로 해서 바로 메소드를 통해 활용할수있게
		review.setStoreId(2);	// 내가 만들어준 게터,세터 활용
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다.");
		
		int count = reviewService.addReviewByObject(review);
		
		// 입력 개수 : 1
		return "입력 개수 : " + count;
		
	
	
	
	}
	
	
	
	
	

}
