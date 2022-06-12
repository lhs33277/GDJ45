package ex04_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CDSVMain {

	public static void main(String[] args) {
		
		// 날짜, 확진자, 사망자			-> BufferedReader : readLine()
		// {"날짜", "확진자", "사망자}	-> String		  : split(",")
		// ["날짜", "확진자", "사망자]	-> Arrays		  : asList()
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("F:\\storage\\코로나.csv"));
			
			String line = null;
			List<List<String>> body = new ArrayList<List<String>>();
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(",");
				List<String> list = Arrays.asList(tokens);
				body.add(list);
				
			}
			
			System.out.println(body);
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			
			
		}

	}

}
