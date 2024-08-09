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
					
	
}
