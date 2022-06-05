package ex03_arithmetic;

public class Ex02_operator {

	public static void main(String[] args) {
		
		// 1씩 증감하기
		
		int a = 10;
		int b = 10;
		
		int res1 = a++;  // a를 res1에 저장한 뒤 a를 1 증가한다. (선사용 후증가)
		int res2 = ++b;  // b를 1 증가한 뒤 res2에 저장한다. (선증가 후사용)
		
		System.out.println(a);
		System.out.println(res1);
		System.out.println(b);
		System.out.println(res2);
		
		// 현재 a는 11, b는 11
		
		int res3 = a--;  // a를 res3에 먼저 저장한 뒤 a를 1 감소한다.
		int res4 = --b;  // a를 먼저 감소한 뒤 res4에 저장한다.
		
		System.out.println(a);
		System.out.println(res3);
		System.out.println(b);
		System.out.println(res4);
		
		// 현재 a는 10, b는 10
		
		int res5 = a++ + --b;
		//a는11 b는9 res5는19
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(res5);
		
		
		
		

	}

}
