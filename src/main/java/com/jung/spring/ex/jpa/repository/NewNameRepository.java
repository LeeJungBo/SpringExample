package com.jung.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jung.spring.ex.jpa.domain.NewName;

//mapper따로 어노테이션 안붙여줌 왜? JPA가 있으니
public interface NewNameRepository extends JpaRepository<NewName, Integer>{// 상속받는다 <Student: 매칭되는 타입 클래스, Integer: 매칭되는 프라이머리 키>
	// 1행 Insert하는 기능이 이미 포함되어있음 아무것도 해줄 필요없음
	
	// id(PK)을 기반으로 하나의 행을 조회하는 기능(수정해주기위해 먼저 조회하기위해)
	
	
}
