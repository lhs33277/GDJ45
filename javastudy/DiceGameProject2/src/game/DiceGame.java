package game;

public class DiceGame {
	/*1. 필드
    1) Player[] players 배열
    2) 배열의 인덱스 idx
2. 생성자
    게임에 참가할 Player의 인원수를 매개변수로 받아 해당 인원수만큼 Player[] players 배열을 생성
3. 메소드
    1) join
        (1) 반환타입 : void
        (2) 메소드명 : join
        (3) 매개변수 : Player player
        (4) 동작
            - 매개변수로 전달된 Player 타입의 player 인스턴스를 players 배열에 저장
            - 필드값으로 가지고 있는 idx 위치에 player를 저장하고 저장한 뒤에는 idx 증가
            - Player 배열이 가득 찬 경우 "더 이상 참여할 수 없습니다." 라는 메시지를 출력하고 메소드 종료
    2) play
        (1) 반환타입 : void
        (2) 메소드명 : play
        (3) 매개변수 : 없음
        (4) 동작
            - Player[] players 배열에 저장된 player들을 인덱스 0부터 순차적으로 동작시킴
            - player의 동작은 turn 메소드를 동작시키는 것을 의미함
            - 각 player의 turn 메소드 실행 결과가 true이면 "누구누구님 승리!" 메시지를 출력하고 메소드 종료
            - 각 player의 turn 메소드 실행 결과가 false이면 다음 플레이어로 이동. 마지막 player 실행후에는 다시 첫 번째 player로 돌아와야 함 */
	
	// 필드
	private Player[] players;
	private int idx;
	
	// 생성자
	public DiceGame(int count) {	// count = 인원수
	players = new Player[count];
	}
	
	// 메소드
	public void join(Player player) {
		players[idx++] = player;
		if ( idx == players.length) {
			System.out.println("더 이상 참여할 수 없습니다.");
		}
	}
	
	public void play() {
		while(true) {
			for (int n = 0; n < players.length; n++) {
				players[n].turn();
				if (players[n].turn() == true) {
					System.out.println(players[n].getName() + "님 승리!");
					return;
				} else continue;
			}
		}
	}

}
