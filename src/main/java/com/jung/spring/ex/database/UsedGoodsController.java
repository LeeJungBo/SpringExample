package com.jung.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.database.domain.UsedGoods;
import com.jung.spring.ex.database.service.UsedGoodsService;

// request와 response 처리 담당(딱 이것만 함)
@Controller
public class UsedGoodsController {

	
	@Autowired
	private UsedGoodsService usedGoodsService;
	// Autowired
		// 객체를 spring에서 자동으로 생성해준다
		// @ Controller @Service @Repository를 만들면 자동생성
		// 해당 어노테이션을 통해서 Spring Bean으로 등록
		// Spring에서 객체 관리를 효율적으로 하기위해 사용
		// DI, IoC, POJO
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody // 화면에 json형태로 나오게 하기위해
	public List<UsedGoods> usedGoodsList(){
		
		// 중고물품 게시글 리스트 얻어 오기(리스트 얻어오는건 얘 역할이 아니어서 request랑 연관없음)
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
		
	}
}
