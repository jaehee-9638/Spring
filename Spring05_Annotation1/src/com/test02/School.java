package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	@Autowired
	@Qualifier("hong")
	private Student person;
	private int grade;
	//오토와이어드는 생성자 , 필드 ,메서드(파라미터있는곳) 세곳에서 적용이 가능
	
	public Student getPerson() {
		return person;
	}
	
	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
}
