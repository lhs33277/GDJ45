package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ParkingLot {

	
	private String name;
	private List<Car> cars;
	private Scanner sc;
	public ParkingLot(String name) {
		super();
		this.name = name;
	cars = new ArrayList<Car>();
	sc = new Scanner(System.in);
	}
	
	public void addCar() {
		System.out.println("차량번호 >>> ");
		String number = sc.next();
		System.out.println("모델 >>>");
		String model = sc.next();
		cars.add(new Car(number, model));
	}
	
	public void deleteCar() {
		System.out.println("차량번호 >>> ");
		String number = sc.next();
		System.out.println("모델 >>>");
		String model = sc.next();
		cars.remove(new Car(number, model));
	}
	
	public void printAllCars() throws RuntimeException {
		System.out.println("===전체 조회하기===");
		System.out.println(name + "차량목록");
		if(cars.isEmpty()) {
			throw new RuntimeException("대상 차량이 존재하지 않습니다.");
		} else {
			for(Car car : cars)
			System.out.println(car);
		}
	}
	
	public void manage() {
		while(true) {
			
			System.out.println("1.추가 2.삭제 3.전체 0.종료");
			int bt = sc.nextInt();
			switch(bt) {
			case 1: addCar();
			case 2: deleteCar();
			case 3: printAllCars();
			case 0: return;
			default: throw new RuntimeException("메뉴 입력");
			} 
			
			}
		}
	
	

	
	
}
