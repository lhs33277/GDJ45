package com.goodee.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId = "ezma1Mug7kwqQDA53trT"; 
        String clientSecret = "5Fi3uc0VQx";
        
        String text = JOptionPane.showInputDialog("검색어");
        try {
        	text = URLEncoder.encode(text, "UTF-8");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        // https://openapi.naver.com/v1/search/book.json
        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;

        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        try {
        	URL url = new URL(apiURL);
        	HttpURLConnection con = (HttpURLConnection)url.openConnection();
        	con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
            
            InputStream body = null;
            int responseCode = con.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) {
            	body = con.getInputStream();
            } else {
            	body = con.getErrorStream();
            }
            
            InputStreamReader streamReader = new InputStreamReader(body);
            
            StringBuilder sb = new StringBuilder();
            
            try {
            	BufferedReader lineReader = new BufferedReader(streamReader);
            	
            	String line;	
            	while((line = lineReader.readLine()) != null) {
            		sb.append(line);
            	}
            } catch (Exception e) {
            	e.printStackTrace();
            }
            
            File dir = new File("C:\\download");
            if(dir.exists() == false) {
            	dir.mkdirs();
            }
            String text2 = URLDecoder.decode(text, "UTF-8");
            File file = new File(dir, text2 + ".html");
            PrintWriter out = new PrintWriter(new FileWriter(file));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>");
            out.println("책검색결과");
            out.println("</title>");
            out.println("<body>");
            
            JSONObject result= new JSONObject(sb.toString());
            // System.out.println(result);

            
            // "title", "link", "image"를 HTML 파일로 저장한다.
            
            JSONArray items = result.getJSONArray("items");
            for(int i = 0; i < items.length(); i++) {
            	JSONObject item =  items.getJSONObject(i);
            	String title = item.getString("title");
            	String link = item.getString("link");
            	String image = item.getString("image");
            	
            	out.println("<div>");
            	out.println("<a href=\"" + link + "\">" + title + "</a>");
            	out.println("<img src=\"" + image + "\" width=\"100px\"><br>");
            	out.println("</div>");
            }
           
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
            System.out.println("생성");
        } catch (Exception e) {
        	File dir2 = new File("C:\\download\\log");
            if(dir2.exists() == false) {
            	dir2.mkdirs();
            }
            try {
            	
                
	            File file2 = new File("error_log.txt");
	            PrintWriter out = new PrintWriter(new FileWriter(file2));
	            Date date = new Date();
	            out.println(e.getMessage());
	            out.println(date);
	            out.flush();
	            out.close();
	            System.out.println("에러파일생성");
            } catch (IOException e2) {
            	e2.printStackTrace();
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
