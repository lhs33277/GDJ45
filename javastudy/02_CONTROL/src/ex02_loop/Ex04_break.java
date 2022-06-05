package ex02_loop;

public class Ex04_break {

	public static void main(String[] args) {
		
		// break
		// 1. switch문을 종료할 때 사용
		// 2. 반복문(for , while)을 종료할 때 사용
		
		// 모금 목표 : 10000
		// 13원씩 모금
		
		int total = 0;
		int money = 13;
		int count = 0;
		while (true) {
			if (total > 10000)
				break;
			total += money;
			count++;
	}
		
	System.out.println("최종모금액은 " + total + "원 입니다.");	
	System.out.println("최종모금인원은 " + count + "명 입니다.");
	
		
	// 전체 구구단
	// 기존 코드는 수정하지 말고, 새로운 코드를 추가해서 5x5=25 까지만 출력
	// scope : 선언한 해당 문 안에서만 쓸 수 있다는 뜻
	// 
	
	int dan , n;
	
	
	for (dan = 2; dan <= 9; dan++) {
		for (n = 1; n<=9; n++) {
			System.err.println(dan + "X" + n + "=" + (dan * n));
		}
	}
	
	
	
	
	
	
	
	outer: for (dan = 2; dan <= 9; dan++) {
		for (n = 1; n<=9; n++) {
			System.err.println(dan + "X" + n + "=" + (dan * n));
			if (dan == 5 && n == 5)
				break outer;
		}
		
	}
	// 안 밖 모두 브레이크 해야함
	// outer: 라벨
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	}

}
