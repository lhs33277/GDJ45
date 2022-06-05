package ex02_try_catch;

public class Main {
	
	public static void m1() {}
		
	public static void m2() {	
		// NullPointerException 처리
		
		try {
		String input = "20, 21, 22, 23.5, 24";
		String[] inputs = input.split(",");
		int[] ages = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			ages[i] = Integer.parseInt(inputs[i]);
			System.out.println((i + 1) + "번 째 입력 나이" + ages[i]);
		}
		} catch(NumberFormatException e) {
			System.out.println("입력은 모두 정수입니다.");
		}
	}
	
	//hobby.substring(0, 2) -> 0~2전까지 출력. 0 1 출력됨
	public static void main(String[] args) {
		m2();
		
	}
	}


