package prac2;

public class Remocon {
	
	// 필드
	private int ch;			// 0~11
	private int vol;		// 0~5
	private final int MAX_CH = 11;
	private final int MAX_VOL = 5;
	
	// 메소드
	public void chUp() {
		if(ch == 11) {
			ch = 0;
			return;
		}
		ch++;
		System.out.println("현재 채널" + ch);
	
	}	
	public void chDown() {
		if (ch == 0) {
			ch = MAX_CH;
			return;
		}
		ch--;
	}
	
	public void volUp() {
		if (vol < MAX_VOL)
			vol++;
	}
	
	public void volDown() {
		if(vol > 0)
			vol--;
	}

}
