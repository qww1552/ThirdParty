package com.example.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NewsItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent intent = getIntent();
        String searchTerm ="코로나+"+ intent.getExtras().getString("location");//검색어

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        AsyncCrawl task = new AsyncCrawl();
        task.execute(searchTerm);

    }

    private class AsyncCrawl extends AsyncTask<String, Void, Elements> {

        @Override
        protected Elements doInBackground(String... lists) {//비동기적으로 실행 ( 33번 줄 실행 시 이부분이 실행됨)
            if(lists.length != 1) {//인수 하나만 받음
                throw new IllegalArgumentException();
            }
            String searchTerm = lists[0];
            Elements items = Crawler.search(searchTerm);//검색결과 받아옴
            return items;
        }

        @Override
        protected void onPostExecute(Elements elements) {//비동기 처리 끝나고 실행
            super.onPostExecute(elements);
            if(elements!=null){//검색 결과가 있을 경우
                for(Element item:elements){
                    Log.d("test","pass");

                    String title = item.select("title").text();
                    String link = item.select("originallink").text();
                    String pubdate=item.select("pubDate").text();
                    String from = findRoot(link);//기사출처
                    list.add(new NewsItem(title, link, pubdate,from));//어레이리스트에 결과 저장(Item 객체)
                }
            }
            MyAdapter myAdapter = new MyAdapter(list);
            recyclerView.setAdapter(myAdapter);
        }
    }

    private static String findRoot(String link) {//기사 출처 추출
        int last = link.indexOf(".com");
        if (last == -1) {
            last = link.indexOf(".kr");
            if(last==-1) last = link.indexOf(".net");

        }
        String res = link.substring(0, last+4);
        return res;
    }

}
