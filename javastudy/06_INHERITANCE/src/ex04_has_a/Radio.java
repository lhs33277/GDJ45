package ex04_has_a;

public class Radio {
	
	private Remocon remocon;  // null
	
	public Radio(Remocon remocon) {
		this.remocon = remocon;
	}
	public void chUp() {
		remocon.chaUp();
	}
	
	public void chDown() {
		remocon.chDown();
	}
}
