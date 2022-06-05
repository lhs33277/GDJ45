package ex07_constructor;

public class Rectangle {
	
	private int width;  // 너비
	private int height;  // 높이
	// private int area;  계산할 수 있어서 필드로 둘 필요 없음
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return width * height;
	}
	
	public void info() {
		System.out.println("너비" + width + ", 높이" + height + ", 넓이" + getArea());  // 같은클래스에서 호출 할 땐 이름만 불러도 됨 겟에이리어
	}

	
	

}
