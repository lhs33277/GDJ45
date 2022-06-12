package phone;

public class Phone {

	//1. 이름(name), 전화번호(tel) 필드와 생성자, getter/setter를 가진 Phone 클래스를 작성하시오.
	
	
	// 필드
	private String name;
	private String tel;
	
	

	// 생성자
	public Phone() {
	}
	
	public Phone (String name, String tel){
		
	this.name = name;
	this.tel = tel;
	}

	
	// 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
}
