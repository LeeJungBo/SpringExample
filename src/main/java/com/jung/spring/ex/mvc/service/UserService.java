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

}
