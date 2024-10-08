package com.jung.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.ex.mvc.domain.User;
import com.jung.spring.ex.mvc.repository.UserRepository;

@Service// 이게 있어야 Service객체가 bean에 등록이 된다 이것때문에 아예 서버가 안켜진거 애초에 service가 등록이 안되어있어 Service와 controller가 연결이 되어있지 않았음
public class UserService { 
	
	@Autowired
	private UserRepository userRepository;
	
	
	// 가장 최근 등록된 사용자 정보 리턴
	public User getLastUser() {
		User lastUser= userRepository.selectLastUser();
		
		return lastUser;
	}
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce){
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;

	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	// 전달 받은 email이 중복된 상태인지 알려주는 기능
	public boolean isDuplicateEmail(
			String email) { // 이메일이 중복됐냐 안됐냐의 true false로만 알릴수 있게
		int count = userRepository.selectCountByEmail(email); // 불린타입이어서 결론만(리턴값) boolean에 부합하면 된다. int로 하고 if로 리턴값만 true, false값으로 
		
		if(count == 0) {
			// 중복안됨
			return false;
		}else {
			// 중복됨
			return true; // 중복되었으니 true
		}
	}
	

}
