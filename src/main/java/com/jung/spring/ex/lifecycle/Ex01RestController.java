package com.jung.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 해당 클래스의 모든 메소드는 ResponseBody 가 적용된다
@RestController // @Controller + @ResponseBody(Response랑 약간 비슷한 기능)
@RequestMapping("/lifecycle/ex01")// 이 아래 있는 클래스들은 이 공통적인것을 기본적으로 잡고 시작한다
public class Ex01RestController {

	//직접 만든 클래스 객체 리턴
	@RequestMapping("/3") //responseBody는 위에서 써줬으니
	public Person objectResponse(){//이거 메소드 이름은 그냥 만들어준거 //직접 만든 클래스이니 타입도 내가 만든 클래스 이름
		Person me = new Person("김인규", 29);
		
		return me;
	}
	
	// status code 전달 (뭔가 잘안될때 브라우저에 뜨는거  ex.500,404이딴것들 있잖아 ㅋㅋㅋ 이걸 강제로 내가 원하는 코드로 띄울수 있게 하는거)
	// 이것도 respons
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse(){
		Person me = new Person("김인규", 30);
		
		// Http Status Code
		// 200 ok(정상적인거)
		// 404 NOT FOUND : 페이지가 없다 (주소 확인 : 보통 주소가 잘못됐다는거)
		// 400 BAD REQUEST : 요청이 잘못 되었다. (파라미터 일치 확인 - 서버에서 3개 전달해달라고 했는데 2개전달 or 이름이 다르다)
		// 405 METHOD NOT ALLOW : 메소드가 일치하지 않음 (Get, Post) - get으로 전달해달라고 했는데 post로 전달했다
		// 500 INTERNAL SERVER ERROR : 서버 에러 (내 코드 확인 : 이건 그냥 내가 잘못한거)
		
		return new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR); //약간 이게 사용법이다
	}
	
	
	
}
