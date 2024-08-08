package com.jung.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.ex.database.domain.UsedGoods;

// 데이터 베이스 관련 처리
// 쿼리 수행(쿼리만 갖고오는 역할)
@Mapper
public interface UsedGoodsRepository {
	// Database query 를 통해서 데이터를 조회, 저장, 수정, 삭제한다
	// Mapper 에서 작성된 query 를 Repository 를 통해서 메소드로 접근한다.
	// Repository는 Java 와 XML 형태의 쿼리를 이어주는 중간 다리
	// DAO (Data Access Object) 라고도 부름
	
	
	
	
	// usedGoods 모든 행 조회(여기서부턴 인터페이스여서 여기서 구현은 못하고 xml을 통해 구현해줘야함(mybatis 활용법임)
	public List<UsedGoods> selectUsedGoodsList(); // 좀있다 물어보기 : 왜 인터페이스에다가는 구현이 안되는건지
		// 인터페이스는 원래 메소드를 정의만 해주는게 사용법이다. 따라서 xml에다가 구체적으로 구현해 놓은것
		// 쿼리의 이름들을 리스트의 형태로 쫙 갖고와서 갖고있어줘야한다

}
