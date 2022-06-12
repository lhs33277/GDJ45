package ex02_method;

public class VendingMachineMain {

	public static void main(String[] args) {
		
		VendingMachine vm = new VendingMachine();
		
		
		// 메소드 호출(call)
		// 인수(인자) : 메소드에 전달하는 값
		String coffee1 = vm.getCoffe(500, 1);
		String coffee2 = vm.getCoffe(1000, 2);
		
		System.out.println(coffee1);
		System.out.println(coffee2);
		
		// 클래스의 구성요소 : 필드 메소드

	}

}
