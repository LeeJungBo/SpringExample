package com.jung.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Builder
@NoArgsConstructor
//public testDto() {} 이런것도 없어도 된다

@AllArgsConstructor
//? 이게 무슨 기능이었더라 (모든 매개변수 생성자 : )
//public testDto(String id, String userName, String age, String address) {
//  this.id = id;
//  this.userName = userName;
//  this.Age = age;
//  this.address = address;(이게 없어도 됨)

@Getter
@Table(name="new_name") // 어떤 테이블에(실제 테이블)매칭될건지를 명시
@Entity // 엔티티 클라스라는걸 명시
public class NewName {

	@Id // 멤버변수하고는 관련없고 프라이머리 키 명시
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 이거 그거다 그 select 해줄때 그 넣어주는 값의 데이터를 id에 매칭해서 그냥 통으로 브라우저에 보여줬던거 그걸 의미
	private int id;
	private String name;
	
	@Column(name="phoneNumber") //본래 JPA는 이름이 길면 _를 넣어주게 되어서 테이블 명칭과 매칭시키기위해 쓰는거
	private String phoneNumber;
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@CreationTimestamp
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 자동으로 업데이트해주는거
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
	
	
	
	
	
}
