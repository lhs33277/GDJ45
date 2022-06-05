package ex05_constructor;

public class Main {

	public static void main(String[] args) {
		Alba alba = new Alba("영수", "서울대", "도서관"); //영수는 스튜던트 통해서 펄슨, 서울대는 스튜던트, 도서관은 알바    // 자기 부모만 부르면 알아서 앞에 불러짐
		
		alba.eat();
		alba.study();
		alba.work();
	}

}
