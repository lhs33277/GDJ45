package ex10_override;

public class Temporary extends Employee {
	
	// 필
	private int payPerHour;	// 시급
	private int times;	// 근무시간
	
	//생 
	public Temporary(String name, int payPerHour) {
		super(name);
		this.payPerHour = payPerHour;
	}
	
	// 메
	public int getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	@Override
	public int getPay() {
		return payPerHour * times;
	}
	

	

}
