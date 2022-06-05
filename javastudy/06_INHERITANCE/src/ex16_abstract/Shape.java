package ex16_abstract;

public abstract class Shape {	// shape은 추상 클래스		// 인스턴스생성(new Shape() ) 불가
	
	private String name;
	

	public Shape(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract double getArea();		// 도형은 삼각형 사각형처럼 넓이 구하는 공식이 없음. '도형'은 추상적인 단어이므로 추상메소드
	
	
	

}
