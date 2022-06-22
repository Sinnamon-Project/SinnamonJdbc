package com.example.SinnamonJDBC.model;




public class Blog_post {


    private int post_id;
    private String title;
    private String date_time;
    private String text_post;
    private String picture;
    private int author;



    @Override
    public String toString() {
        return "blog_Post{" +
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", date_time='" + date_time + '\'' +
                ", text_post='" + text_post + '\'' +
                ", picture='" + picture + '\'' +
                ", author=" + author +
                '}';
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public void setText_post(String text_post) {
        this.text_post = text_post;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getText_post() {
        return text_post;
    }

    public  String getPicture() {
        return picture;
    }

    public int getAuthor() {
        return author;
    }
}

