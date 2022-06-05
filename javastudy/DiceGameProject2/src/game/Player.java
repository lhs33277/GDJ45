package game;

public class Player {
	/* 
	 1. 필드
    이름(name)
2. 생성자
    이름을 매개변수로 받아서 필드에 전달하는 생성자
3. 메소드
    1) getter
    2) setter
    3) turn
        (1) 반환타입 : boolean
        (2) 메소드명 : turn
        (3) 매개변수 : 없음
        (4) 동작
            - 길이가 3인 int 배열을 생성하고 3개의 주사위 던지기 결과를 저장한다.
            - 주사위 던지기 결과를 출력한다.
            - 3개의 주사위 던지기 결과가 모두 동일하면 "성공!"을 출력하고, 아니면 "실패!"를 출력한다.
            - 3개의 주사위 던지기 결과가 모두 동일하면 true를 반환하고, 아니면 false를 반환한다.
            */
	
	
	// 필드
	private String name;

	// 생성자
	public Player(String name) {
		super();
		this.name = name;
	}

	// 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean turn() {
		int[] arr = new int[3];
		System.out.println("===" + name + "님의 주사위 결과 ===");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ((int)(Math.random() * 6))+1;
			System.out.print(arr[i] + " ");
			}
		
			if (arr[0] == arr[1] && arr[1] == arr[2]) {
				System.out.println("성공!");
				return true;
			} else {System.out.println("실패!");
				return false;
			}
		
	}

	
}
