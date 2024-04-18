package com.example.osproject.Misc;

import com.example.osproject.Account.Account;

import java.io.Serializable;
import java.util.ArrayList;

public class Review implements Serializable {
    private Account author;
    private String message;
    private int score;
    private ArrayList<Integer> Images;

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Integer> getImages() {
        return Images;
    }

    public void addImages(Integer image) {
        Images.add(image);
    }

}
