package com.jung.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.ex.database.domain.UsedGoods;
import com.jung.spring.ex.database.repository.UsedGoodsRepository;


// 로직(bussiness) 담당
// 데이터를 수정 가공
// 그 외 복잡한 기능 수행
@Service
public class UsedGoodsService {
	// Controller와 Repository 를 연결하는 중간다리 역할
	// Controller 에서 전달받은 데이터를 Repository 에 가공하여 전달
	// Repository 로 부터 전달 받은 데이터를 Controller로 가공하여 전달
	// Bo(Business Object)라고도 부름
	
	
	
	// 레파지토리에 있는 정보를 가져와야함 객체를 가져와야하는데 이걸 
	// Repository 객체 관리를 스프링에게 위임
	@Autowired   // 이걸 붙여주는 순간 무분별하게 호출되는게 아닌 스프링이 과부하가 걸리지 않게 객체를 알아서 관리
			     //(이걸 통해서 스프링이 상황을 보면서 sigleton과정등을 통해 그쪽으로 알아서 돌려서 쓸수도 있게 씀)
	private UsedGoodsRepository usedGoodsRepository;


	// 중고물품 게시글 리스트 리턴 기능
	public List<UsedGoods> getUsedGoodsList() {
		// usedGoods 테이블 모든행 조회(하지만 얘의역할중에 조회 역할은 없다 따라서, 어디 다른데다가 만들어줘야함)
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
		
	}
	
	
	
}
