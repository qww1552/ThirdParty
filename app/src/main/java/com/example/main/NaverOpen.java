package com.example.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverOpen {
    public static String NaverNews(String searchTerm){
        String clientId = " a8_awGUdinNnvnhetbQj";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "p_eikkukyR";//애플리케이션 클라이언트 시크릿값";
        String res="";

        try {
            String text = URLEncoder.encode(searchTerm, "UTF-8"); //검색어";
            String apiURL = "https://openapi.naver.com/v1/search/news.xml?query="+ text +"&display=100&sort=sim"; // 뉴스의 xml 결과

            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            res = filter(response.toString());// xml태그가 제거된 검색 결과
            //Log.d("검색결과",res);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    private static String filter(String string){//검색 결과에서 xml태그 제거
        string = string.replace("&amp;","&");
        string = string.replace("&quot;","\"");
        string = string.replace("&apos;","\'");
        string = string.replace("&nbsp","");
        string = string.replace("&lt;b&gt;","");//<b> 태그 제거
        string = string.replace("&lt;/b&gt;","");// </b> 태그 제거
        return string;
    }
}
