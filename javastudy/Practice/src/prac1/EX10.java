package prac1;

public class EX10 {

	public static void main(String[] args) {
		
		Gun gun = new Gun("K2");
		Soldier soldier = new Soldier(gun, "람보");
		
		gun.reload(2);
		gun.shoot();
		
		gun.reload(10);
		gun.info();
		
		soldier.reload(2);
		soldier.shoot();
		
		soldier.info();

	}

}
