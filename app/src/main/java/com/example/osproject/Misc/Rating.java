package com.example.osproject.Misc;

import java.io.Serializable;

public class Rating implements Serializable {
    private float ratingScore = 0;
    private Integer[] ratings = {0, 0, 0, 0, 0};
    private int ratingSize = 0;


    public Integer[] getRatings() {
        return ratings;
    }

    public void addRating(Integer rating)  {
        if (rating<1 || rating>5)
            return;
        ratings[rating-1] = ratings[rating-1] + 1;
        ratingSize++;
        calculateRatingScore();
    }

    public float getRatingScore(){
        return ratingScore;
    }

    private void calculateRatingScore() {
        ratingScore = ((float)(ratings[0]*1) + (float)(ratings[1]*2) + (float)(ratings[2]*3) + (float)(ratings[3]*4) + (float)(ratings[4]*5))/(float)ratingSize;
    }

    public int getRatingSize() {
        return ratingSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%2.1f", ratingScore));
        sb.append("/5 ⭐");
        return sb.toString();
    }

}
