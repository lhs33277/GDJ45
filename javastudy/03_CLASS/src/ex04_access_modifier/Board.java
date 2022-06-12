package ex04_access_modifier;

// 접근 제어 지시자
// 1. 클래스를 구성하는 요소(필드, 메소드, 생성자)들의 접근 권한
// 2. 종료
//   1) private : 클래스의 내부에서만 접근할 수 있다.
//   2) default : 동일한 패키지에서만 접근할 수 있다. 다른 클래스여 패키지가 같으면 가능. (기본값)
//   3) protected : 동일한 패키지 + 상속 관계의 다른 패키지에서만 접근 (필요 없음)
//   4) public : 누구나 접근할 수 있다.
// 3. 일방적인 적용
//   1) 필드 : private  (이것만알면됨)
//   2) 메소드 : public
//   3) 생성자 : public   (생성자도 메소드니까)

public class Board {
	
	// 필드
	private int boardNo;
	private String title;
	
	// 생성자
	public Board () {
		
		
	}
	public Board (int boardNo , String title) {
		this.boardNo = boardNo;         //.눌렀을때 빨간거 프라빗 파란거 디폴트
		this.title = title;
	}
	
	
	
	// 메소드
	// void : 반환값/반환타입이 없을 때 사용
	
	
	//setter
	// 1. 필드에 값을 저장하기 위한 메소드
	// 2. set + 필드명으로 메소드명을 결정한다.
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
	
	// getter
	// 1. 필드의 값을 반환하기 위한 메소드
	// 2. get + 필드명으로 메소드명을 결정한다.
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public void info() {                            //들어오는것도 나가는것도 없어서 입력에 따라 값이 변하지 않고 하는일이 항상 똑같음
		System.out.println("글번호: " + boardNo);
		System.out.println("글제목: " + title);
	}
	
	
}
