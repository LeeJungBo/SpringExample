package com.jung.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.ex.jpa.domain.Student;
import com.jung.spring.ex.jpa.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	// C, U, D
	@GetMapping("/jpa/student/create")
	@ResponseBody
	public Student createStudent() {
		 // 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자"); // 이렇게 만들면서 쿼리가 insert되고 그렇게 되면 id, createdAt, updatedAt 모두 저절로 브라우저 화면에 뜸
				
		return student;
		
	}
	
	
	
	
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest(){
		
//		Student student = new Student(10, "김인규", "010-1111-2222", "lecture@hagulu.com", "프로그래머", null, null);
//		student.setPhoneNumber("010-0000-9999");// 바꾸고 싶으면 setter호출
		
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-0000-1111")
				.dreamJob("프로그래머")
				.email("lecture@hagulu.com")
				.build(); // 이런식으로 객체 생성도 가능하다 (빌더 패턴을 이용해서)
		
		return student;  // 브라우저에 화면에 뜬다
		
		
	}
	
}
