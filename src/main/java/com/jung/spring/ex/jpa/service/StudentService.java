package com.jung.spring.ex.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.ex.jpa.domain.Student;
import com.jung.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob){
		
		Student student = Student.builder()
		.name(name) // 가로안이 받은 값(위에꺼) 초록색name은 단지 변수일뿐이고 실제값은 파란색name임
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob)
		.build();
		
		Student result = studentRepository.save(student); // JpaRepository<Student, Integer> 이걸 상속받으면 자동적으로 메소드 save등 많은것들이 자동생산
		return result;
		
	}
	
}
