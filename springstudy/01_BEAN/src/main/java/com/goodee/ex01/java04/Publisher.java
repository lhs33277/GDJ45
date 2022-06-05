package com.goodee.ex01.java04;

public class Publisher {
	
	// field
	private String name;
	private String tel;
	
	@Override
	public String toString() {
		return "[name=" + name + ", tel=" + tel + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
