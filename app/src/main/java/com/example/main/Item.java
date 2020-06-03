package com.example.main;

public class Item {
    private String title;
    private String link;
    private String pubdate;
    private String from;

    public Item(String title, String link, String pubdate,String from){
        this.title = title;
        this.link = link;
        this.pubdate = pubdate;
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }
}

