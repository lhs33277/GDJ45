package game;

public class DiceGameMain {

	/*<< DiceGameMain 클래스 >>
	1. 필드
	    없음
	2. 생성자
	    없음
	3. 메소드
	    1) main 메소드
	    2) 동작
	        - 3명의 참가자가 참가할 수 있는 DiceGame 생성
	        - "호랑이", "코뿔소", "도마뱀" 참가자를 DiceGame에 참가시킴(join)
	        - DiceGame 실행(play) */
	
	
	public static void main(String[] args) {
		
		DiceGame dice = new DiceGame(3);
		dice.join(new Player("호랑이"));
		dice.join(new Player("코뿔소"));
		dice.join(new Player("도마뱀"));
		dice.play();
		
	}
}
