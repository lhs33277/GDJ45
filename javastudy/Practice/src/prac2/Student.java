package prac2;

public class Student {
	
	// 필드
	private String name;
	private Exam[] exams;
	private int idx;
	
	// 생성자
	public Student(String name) {
		this.name = name;
		exams = new Exam[2]; // 매개변수가 있으면 this를 쓰고 없으면 안씀. 매개변수와 동일한 변수 이름이 있으면 this사용.
	}
	
	public void doExam(Exam ex) {
		if(idx == exams.length)
			return;
		exams[idx++] = ex;
	}
	public double getAverage() {
		// 각 Exam의 인스턴스 : exams[0] , exams[1]
		// 각 Exam의 평균 : exams[0].getAverage(), exams[1].getAverage()
		double total = 0;
		for(int i = 0; i < idx; i++)
			total += exams[i].getAverage();
		return total / idx;
	}
	public String getGrade() {
		double average = getAverage();
		if (average >= 90)
			return "A";	
		else if (average >= 80)
			return "B";
		else if (average >= 70)
			return "C";
		else if (average >= 60)
			return "D";
		else
			return "F";
		}
	
	
	public void info() {
		System.out.println("학생명" + name);
		// 각 Exam 인스턴스 : exams[0], exams[1]
		// 각 Exam의 정보 : exam[0].info(), exam[1]/info()
		for(int i = 0; i <idx; i++) {
			System.out.println("===" + (i+1) + "번 째 시험정보===");
			exams[i].info();
		}
	

	
	
	}

}
