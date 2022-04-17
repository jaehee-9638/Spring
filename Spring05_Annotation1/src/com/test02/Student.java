package com.test02;

public class Student {
	
	private String name;
	private String addr;
	private int age;
	
	
	public Student() {
		
	}
	public Student(String name, String addr, int age) {
		super();
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
	
}
