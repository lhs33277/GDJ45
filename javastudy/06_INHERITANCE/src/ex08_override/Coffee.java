package ex08_override;

public class Coffee {
	
	private String bean;
	
	public Coffee(String bean) {
		this.bean = bean;		// 받아온 bean을 필드값에 넘겨주는 작업
	}
	
	public void taste() {
		System.out.println("씹는 맛");
	}
	
	public void info() {
		System.out.println("원두: " + bean);
	}

}
