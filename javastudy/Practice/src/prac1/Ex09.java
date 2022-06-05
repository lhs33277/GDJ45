package prac1;

public class Ex09 {

	public static void main(String[] args) {
		
		BankAccount me = new BankAccount("1234" , 50000L);
		BankAccount mom = new BankAccount("5678" , 100000L);
		
		mom.transfer(me, 30000);
		
		me.withdraw(0);
		
		me.inquiry();
		mom.inquiry();

	}

}
