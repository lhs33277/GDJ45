package ex05_constructor;

public class Alba extends Student {
	
	private String company;
	
	public Alba(String name, String school, String company) {
		// Student 클래스의 생성자를 호출해야 한다.
		super(name, school);
		this.company = company;	// 순서 바꾸면 오류
	}
	
	public void work() {
		System.out.println(company + "에서 일한다.");
	}

}
