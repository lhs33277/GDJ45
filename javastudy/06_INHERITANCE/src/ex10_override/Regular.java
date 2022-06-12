package ex10_override;

public class Regular extends Employee {
	
	//필
	private int salary;

	//생
	public Regular(String name, int salary) {
		super(name);
		this.salary = salary;
	}
	
	//메
	@Override
	public int getPay() {
		return salary;
	}
	

}
