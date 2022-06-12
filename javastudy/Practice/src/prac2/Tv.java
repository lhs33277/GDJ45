package prac2;

public class Tv {
	
	// 필드
	private Remocon remocon;   // null

	// 메소드
	public Remocon getRemocon() {
		return remocon;
	}

	public void setRemocon(Remocon remocon) {
		this.remocon = remocon;
	}
	
	public void chUp() {
		remocon.chUp();
	}
	
	public void chDown() {
		remocon.chDown();
	}
	
	public void volUp() {
		remocon.volUp();
	}
	
	public void volDown(){
		remocon.volDown();
	}
	

}
