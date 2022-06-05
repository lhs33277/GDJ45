package ex01_primitive_array;

public class Ex01_array {

	public static void main(String[] args) {
		
		
		// 배열
		// 1. 변수를 여러개 모아놓은 자료형이다.
		// 2. 참조타입 (주소저장)
		// 3. 자동으로 0으로 초기화된다.
		// 4. 각 변수의 구분은 인덱스(index)로 한다.
		// 5. 인덱스(index)의 시작은 0이다.
		
		
		
		
		int[] arr = new int[5];
				
		arr[0] = 100;
		arr[1] = 200;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		
		
		// arr에는 주소가 들어갈 수 있는 형태로 바뀜. 참조변수임
		// 모든 클래스타입은 참조타입(reference)
		// 뉴 = 메모리만드세요 , 뒤 : 정수5개만드세요
		// 5개의 변수가 만들어질 수 있는 주소가 나란히 생김 흩어져있지않음
		// 만들어진 5개의 변수중 첫번째변수 : arr[0] 둘째변수 : arr[1] ... arr[4] / 1은 123번지에서 한칸 떨어졌다는 뜻
		// 0부터 시작 / 0~4번호는 index라고 부름.
		//배열은 자동0 초기화 값입력안하면 자동0

	}

}
