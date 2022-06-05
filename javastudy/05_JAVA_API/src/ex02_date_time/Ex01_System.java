package ex02_date_time;

public class Ex01_System {

	public static void main(String[] args) {


		// 1. timestamp
		//	1970-01-01 0:00부터 1/1000초마다 증가하고
		Long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		
		// 2. nanotime
		//	1) 어떤 기준점은 없다.
		//	2) 1/1,000,000,000초 단위의 long 타입의 정수 값  (1/10억)
		//	3) 경과 시간을 계산하는 용도이다.
		long begin = System.nanoTime();
		
;		long end = System.nanoTime();
		System.out.println((end - begin) + "ns");
		
		
		
	} 
	

}
