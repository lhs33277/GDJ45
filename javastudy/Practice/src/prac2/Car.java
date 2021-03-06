package prac2;

// speed : 0~100km
// oil : 0~50L

// speedUp : speed 10증가
// 		   : oil 1L 감소

// speedDown : speed 10감소
//	         : oil 감소 없음
public class Car {
	private int speed;	// 0
	private int oil;	// 0
	public final int MAX_SPEED = 100;	// 상수값은 public 처리해도 무방하다.
	public final int MAX_OIL = 50;		// 실제로 public처리 많이 함.
	
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed > MAX_SPEED) {
			this.speed = MAX_SPEED;
			return;
		}
		this.speed = speed;
	}
	public int getOil() {
		return oil;
	}
	public void setOil(int oil) {
		if(oil > MAX_OIL) {
			this.oil = MAX_OIL;
			return;
		}
			this.oil = oil;
	}
	
	
	
	public void speedUp() {
		if(oil > 0 ) {
			speed += 10;
			oil--;
			if(speed > MAX_SPEED)
				speed = MAX_SPEED;
		}
	
	}
	
	public void speedDown() {
		speed -= 10;
		if(speed < 0)
			speed = 0;
	}
	public void info() {
		System.out.println("속도: " + speed + "km, 연료: " + oil + "L");
	}

	
	

}
