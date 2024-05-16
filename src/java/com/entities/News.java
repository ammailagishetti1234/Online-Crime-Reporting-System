
package com.entities;

public class News {
    private int id;
    private String title;
    private String date_time;
    private String content;

    public News(int id, String title, String date_time, String content) {
        this.id = id;
        this.title = title;
        this.date_time = date_time;
        this.content = content;
    }

    public News(String title, String date_time, String content) {
        this.title = title;
        this.date_time = date_time;
        this.content = content;
    }

    public News() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setString(String date_time) {
        this.date_time = date_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
