package com.goodee.ex01.xml02;

public class Car {
	
	// field
	private String model;	// xDrive 40d
	private int price;		// 13140
	private Engine engine;
	
	// getter/setter
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car() {
		
	}
	
	// info() 메소드
	public void info() {
		System.out.println("모델명 : " + model + "가격 : " + price);
		engine.info();
	}

}
