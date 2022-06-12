package ex04_access_modifier;

public class BoardMain {

	public static void main(String[] args) {
		
		Board board1 = new Board();  // 호출 빈거 찾아서 연결
		Board board2 = new Board(2 , "공지사항");  // 호출 2개짜리 찾아서 연결  (연결 : 바인딩)
		
		
		board1.setBoardNo(1);
		board1.setTitle("필독");
		
		System.out.println("글번호: " + board1.getBoardNo());
		System.out.println("글제목: " + board1.getTitle());   //첫두개가 이거로 보여준거임 나머지 밑에4개는 인포로 보여준거임.
		
		
		
		board1.info();   // info 메소드 호출
		board2.info();
		
		
		
		
		
		
		
		
		

	}

}
