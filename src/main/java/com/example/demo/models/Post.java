package com.example.demo.models;

public class Post {
    public String title;
    public String content;
    public String date;
    public String color;
    public String publicOrNot;

    public Post (String title, String content, String date, String color, String publicOrNot){
        this.title = title;
        this.content = content;
        this.date = date;
        this.color = color;
        this.publicOrNot = publicOrNot;
    }

    @Override
    public String toString(){
        return "Post >  Title: " + title + " | Content: " + content + " | Date: " + date +
                " | Your chosen color: " + color + " | Public Post? " + publicOrNot;
    }
}
