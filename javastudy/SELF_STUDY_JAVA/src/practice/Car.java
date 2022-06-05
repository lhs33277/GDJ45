package practice;

public class Car {
	
	// 필드
	int speed;
	
	
	// 메소드
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
			return;
		} else
		this.speed = speed;
	}

	
	

}
