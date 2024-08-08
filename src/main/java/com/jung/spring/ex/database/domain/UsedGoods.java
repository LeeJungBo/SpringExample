package com.jung.spring.ex.database.domain;

import java.time.LocalDateTime;

// usedGoods의 한행의 정보를 모두 저장할 수 있는 객체를 위한 클래스(한줄 통째로 가져와야해서 Map형태보다 아예 타입을 만들어주는것)
// 테이블의 컬럼이름과 정확히 일치하는 이름의 멤버 변수 정의
// Domain, EntityClass(기억해둘것) 즉 도메인이라는건 어떤 고유의 클래스로 타입에 넣어주어 
// Table 의 컬럼과 일치하는 멤버변수를 가진 클래스
// 객체 하나가 테이블의 하나의 행을 의미
// 조회된 한 행의 결과를 컬럼에 매칭되어 멤버변수에 저장
// 한행을 insert 하는 과정에서도 사용
// Domain, Entity라고 부름
public class UsedGoods {
	
	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	

}
