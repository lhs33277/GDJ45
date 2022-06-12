package ex10_override;

public class Employee {
	
	private String name;

	//생
	public Employee(String name) {
		super();
		this.name = name;
	}

	//메
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPay() {
		return 0;
	}
	
	

}
