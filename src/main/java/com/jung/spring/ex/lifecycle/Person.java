package com.jung.spring.ex.lifecycle;

public class Person {
	
	// 이름, 나이
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//실무에서는 멤버변수들의 getter,setter를 모두 만들어준다 (그래야 쓰지)

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	

}
