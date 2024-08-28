package com.jung.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.ex.jpa.domain.NewName;
import com.jung.spring.ex.jpa.repository.NewNameRepository;

@Service
public class NewNameService {
	
	@Autowired
	private NewNameRepository newNameRepository;
	
	
	public NewName addNewName(String name, String phoneNumber, String email, String dreamJob) {
				
		NewName newName = NewName.builder()
		.name(name)  // 가로안이 받은 값(위에꺼) 초록색name은 단지 변수일뿐이고 실제값은 파란색name임
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob)
		.build();
		

		NewName result = newNameRepository.save(newName); // JpaRepository<Student, Integer> 이걸 상속받으면 자동적으로 메소드 save등 많은것들이 자동생산
		return result;
	}
	
	
	// id와 장래희망을 전달 받고, 수정하는 기능
	public NewName updateNewName(int id, String dreamJob){
		// update 대상을 먼저 조회 한다.(msql에서는 바로 수정을 해줬겠지만
		// 조회된 객체에서 수정을 진행한다.
		// 해당 객체를 저장한다.
		
		// Optional
		// null일수도 있는 객체를 저장할때 사용하는 객체 (조회가 안되면 null일수도 있는걸 방어하기 위함 그냥 NewName newName을 써버리면 nullpointException이 뜸 매우 위험한 오류)
		// 이 타입은 null일수도 있는 객체를 리턴할때 사용한다.(오류를 방어하기 위함)
		Optional<NewName> optionalNewName = newNameRepository.findById(id); // Optional<NewName> 이게 여기의 객체 타입이다.
		
		// NewName newName = optionalNewName.orElse(new NewName()); // null이면 어떤 값을 받겠다는 걸 의미하는 메소드 (null이면 new NewName() 이걸 리턴한다는거)
		
		NewName newName = optionalNewName.orElse(null);
		
		newName = newName.toBuilder().dreamJob(dreamJob).build(); // 수정하기위함
		
		NewName result = newNameRepository.save(newName); // 수정된 쿼리를 저장 // 수정할 쿼리는 기존의 프라이머리키(id)가 있어서 알아서 자동으로 insert인지 update인지 구분해서 수행
		
		return result;
		
	}
	
	
	public void deleteNewName(int id){
		// 삭제 대상을 조회한다
		// 조회된 객체를 통해 삭제한다.
		Optional<NewName> optionalNewName = newNameRepository.findById(id);
		NewName newName = optionalNewName.orElse(null);
		
		newNameRepository.delete(newName); // delete는 리턴할값이 없음 void로
		
		
	}
	
	
	
}
