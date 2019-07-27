package com.venture.vebschool.Parent.MenuActivities.News;

public class NewsModel {
    String id,title,date,content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsModel(String id, String title, String n_date, String n_content) {
        this.id=id;
        this.title=title;
        this.date=n_date;
        this.content=n_content;
    }
}
