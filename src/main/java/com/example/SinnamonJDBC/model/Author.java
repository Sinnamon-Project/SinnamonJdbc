package com.example.SinnamonJDBC.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Author {
    private int author_id;
    private String first_name;
    private String last_name;

    private Blog_post blogPost;
    @JsonSetter("blogPost")
    public void setBlogPost(Blog_post blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
