package com.jung.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.jpa.domain.NewName;
import com.jung.spring.ex.jpa.repository.NewNameRepository;
import com.jung.spring.ex.jpa.service.NewNameService;

@Controller
@RequestMapping("/jpa/newName")
public class NewNameController {

	@Autowired
	private NewNameService newNameService;
	
	//임시로 하는거
	// 이렇게 바로 레파지토리 갖고와서 하는거 절대 아님 단지 그냥 임시로 하는거
	@Autowired
	private NewNameRepository newNameRepository;
	
	@GetMapping("/create")
	@ResponseBody
	public NewName createNewName() {
		
		NewName newName = newNameService.addNewName("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자"); // 이렇게 만들면서 쿼리가 insert되고 그렇게 되면 id, createdAt, updatedAt 모두 저절로 브라우저 화면에 뜸
		
		return newName;
	}
	
	
	@GetMapping("/update")
	@ResponseBody
	public NewName updateNewName() {
		// id가 3인 학생정보의 장래희망을 강사로 변경
		NewName newName = newNameService.updateNewName(3, "강사");
		return newName;
	}
	
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteNewName() {
		// id가 4인 학생정보 삭제
		newNameService.deleteNewName(3);
		
		return "삭제!";
	}
	
	@GetMapping("/find")
	@ResponseBody
	public List<NewName> findNewName(){
		
		// 모든행 조회
		List<NewName> newNameList = null;
				//newNameRepository.findAll();
		
//		newNameList = newNameRepository.findAllByOrderByIdDesc();
		
//		newNameList = newNameRepository.findTop2ByOrderByIdDesc();
		
//		newNameList = newNameRepository.findByName("김인규");
		
		List<String>nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
//		newNameList = newNameRepository.findByNameIn(nameList);
//		newNameList = newNameRepository.findByEmailContaining("naver");
		newNameList = newNameRepository.findByIdBetweenOrderByIdDesc(2, 3);

//		newNameList = newNameRepository.selectByDreamJob("프로그래머");
		return newNameList;
	}
	
	
	
	
	
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public NewName lombokTest() {
		
//		NewName newName = new NewName(10, "김인규", "010-1111-2222", "lecture@hagulu.com", "프로그래머", null, null);
//		newName.setPhoneNumber("010-0000-9999");// 바꾸고 싶으면 setter호출
		
		
		
		
		NewName newName = NewName.builder()
						.name("김인규")
						.phoneNumber("010-0000-1111")
						.dreamJob("프로그래머")
						.email("lecture@hagulu.com")
						.build();  // 이런식으로 객체 생성도 가능하다 (빌더 패턴을 이용해서)
		
		return newName; // 브라우저에 화면에 뜬다
		
		
	}
	
	
	
}
