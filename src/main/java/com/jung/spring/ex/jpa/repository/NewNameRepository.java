package com.jung.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jung.spring.ex.jpa.domain.NewName;

//mapper따로 어노테이션 안붙여줌 왜? JPA가 있으니
public interface NewNameRepository extends JpaRepository<NewName, Integer>{// 상속받는다 <Student: 매칭되는 타입 클래스, Integer: 매칭되는 프라이머리 키>
	// 1행 Insert하는 기능이 이미 포함되어있음 아무것도 해줄 필요없음
	
	// id(PK)을 기반으로 하나의 행을 조회하는 기능(수정해주기위해 먼저 조회하기위해)
	
	
	
	// id기준으로 내림차순 정렬된 결과 조회
	// ORDER BY `id` DESC
	// 여기선 규칙을 통해서 새로운 메소드를 만들어야한다.
	public List<NewName> findAllByOrderByIdDesc(); // 이건 규칙임(자기가 알아서 메소드이름 짓기 x)
	
	// id기준으로 내림차순환 결과를 2개만 조회
	// ORDER BY `id` DESC LIMIT 2
	public List<NewName> findTop2ByOrderByIdDesc();
	
	// 전달 받은 이름과 일치하는 행 조회
	// WHERE `name` = #{name}
	public List<NewName> findByName(String name);
	
	// 전달받은 이름 들과 일치하는 행 조회
	// WHERE `name` IN (#{name}, #{name2})
	public List<NewName> findByNameIn(List<String> nameList);// 문자열로 전달 받음 List
	
	// 전달 받은 값이 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE '%gmail%'
	public List<NewName> findByEmailContaining(String email);
	
	// id컬럼의 값이 특정값 사이에 대응 되는 행을 id 기반으로 내림파순 정려 한 결과 조회
	// WHERE `id` BETWEEN 1 AND 5 ORDER BY `id` DESC --> 아이디 1과 5사이의 값 조회
	public List<NewName> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리를 직접 작성해서 실행(예외적으로 사용 아무리 위에 메소드들이 있어도 구체적으로 쿼리를 쓰기위해서 쓸때도 있음)
	// Native Query(메소드 규칙 없음)
	// dreamJob 컬럼이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `new_name` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<NewName> selectByDreamJob(@Param("dreamJob") String dreamJob); //위에 어노테이션으로 규정지워져서 메소드의 규칙필요없이 만들어서 내가 원하는 쿼리이름기준 조회가능
	
}
