package prac2;

// 평균 계산
// 학점 : A90, B80, C70, D60, F나머지 중 하나

public class Exam {
	
	//필드
	private int kor;
	private int eng;
	private int math;
	
	// 생성자
	public Exam() {
		kor = (int)(Math.random() * 101);
		eng = (int)(Math.random() * 101);
		math = (int)(Math.random() * 101);
	}
	
	// 메소드
	public double getAverage() {
		return(kor + eng + math) / 3.0;
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
		System.out.println("국어 :" + kor + "점, 영어 :" + eng + "점, 수학 :" + math + "점");
		System.out.println("평균 :"+ getAverage() + "점(" + getGrade() + "학점)");
	}
	
	
	

}
