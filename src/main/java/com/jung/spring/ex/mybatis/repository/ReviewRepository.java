package com.jung.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jung.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

	// id가 5인 행 조회 - 한행만 조회하는 거이기 때문에 List 아님
	// 전달 받은 id와 일치하는 행 조회
	public Review selectReview(@Param("id") int id);// int id 만 넣는건 자바언어여서 xml에서 쓸수가 없기때문에 @Param("id")이걸통해 연결점을 만들어주는거다
													// reviewRepository.selectReview(5); 여기 가로안에 넣는것도 넣어줘야한다
				
	
	// 리뷰테이블에 한행 저장에 필요한 정보를 전달 받고 한행을 insert
	public int insertReview( // 한행이니 그냥 int
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			,@Param("review") String review);
	
	// insert는 사실 기능 수행만 하면 되어서 리턴타입을 따로 정해줄 필요가 없다 따라서 그냥 사용법을 int로 해서 수행된 행의 개수를 돌려받게끔
	// 리뷰테이블에 한행 저장에 필요한 정보를 객체로 전달 받고 한행을 insert
	public int insertReviewByObject(Review review); // insert 의 리턴타입은 int로 고정되어있음
	
	
	
}
