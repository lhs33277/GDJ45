package ex02_casting;

public class Ex02_parse {

	public static void main(String[] args) {
		
		// 1. "100" -> 100
		String Str1 = "100";
		int a = Integer.parseInt(Str1);
		
		System.out.println(a);
		
		
		// 2. "200" -> 200L
		String Str2 = "200";
		long b = Long.parseLong(Str2);
		
		System.out.println(b);
		
		
		// 3. "1.5" -> 1.5
	String str3 = "1.5";
	double c = Double.parseDouble(str3);
	System.out.println(c);


	}

}
