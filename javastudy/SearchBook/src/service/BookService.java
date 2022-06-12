package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BookDAO;
import dto.Book;

public class BookService {
	
	// 필드
	private Scanner sc;
	private BookDAO dao;
	
	// 생성자
	public BookService() {
		sc = new Scanner(System.in);
		dao = BookDAO.getInstance();
	}
	
	// 메소드
	public void searchBook() {
		
		String clientId = "WiiHW43ucrATJvCatiYq";
		String clientSecret = "rE10NhkWOR";
		
		// 검색어 입력
		System.out.println("검색어 입력 >>> ");
		String text = sc.next();
		
		// 검색어 인코딩
		try {
			text = URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패");
		}
		
		// 요청url
		// get방식은 url에 검색어가 포함되어 있다.
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;
		
		// 요청(client -> server)
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("get");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		} catch (MalformedURLException e) {
			throw new RuntimeException("api url이 잘못되었습니다.");
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다.");
		}
		
		// 응답(response : server -> client)
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			int responseCode = con.getResponseCode();	
			if(responseCode == HttpURLConnection.HTTP_OK) {		// 성공 200
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {	// 실패
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");	// \n은 생략가능
			}
		} catch (IOException e) {
			throw new RuntimeException("api 응답을 읽는데 실패했습니다.");
		}
		
		// 응답(json) 확인
		System.out.println(sb.toString());
		
		// json응답 -> book 인스턴스
		JSONObject result = new JSONObject(sb.toString());
		JSONArray items = result.getJSONArray("items");
		for(int i = 0; i < items.length(); i++) {
			JSONObject item = (JSONObject)items.get(i);
			Book book = new Book();
			book.setTitle(item.getString("title"));
			book.setLink(item.getString("link"));
			book.setImage(item.getString("image"));
			book.setAuthor(item.getString("author"));
			
		}
		
		// dao의 insertBook() 메소드 호출
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
