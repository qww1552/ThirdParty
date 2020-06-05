package com.example.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler {
    /*public static Elements search(String location) {
        Document doc=null;
        Elements articles =null;
        String baseUrl = "https://news.google.com/rss/";
        String term = "search?q=%EC%BD%94%EB%A1%9C%EB%82%98%20%2B%20"
                +location
                +"&hl=ko&gl=KR&ceid=KR%3Ako";
        try {
            doc = Jsoup.connect(baseUrl+term).get();
            articles = doc.select("item");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }*/
    public static Elements search(String searchTerm) {

        String string = NaverOpen.NaverNews(searchTerm);//네이버 뉴스검색 이용해서 검색 결과 받아옴

        Document doc = Jsoup.parse(string);
        Elements items;

        items = doc.select("item");//검색결과에서 <item>태그 전부 읽어옴

        return items;
    }
}