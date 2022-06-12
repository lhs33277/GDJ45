package ex10_override;

public class Sales extends Regular {
	
	private int salesVolume;
	private double incentive;

	// 필드를 이용해서 들어가는 생성자는 없음
	public Sales(String name, int salary) {
		super(name, salary);
	}
	
	
	// 메


	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	public int getSalesPay() {
		return (int)(salesVolume * incentive);
	}
	
	@Override
	public int getPay() {
		//return 기본급 + 판매수당
		return super.getPay() + getSalesPay();
	}
	
	







}
