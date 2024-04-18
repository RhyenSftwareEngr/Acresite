package com.example.osproject.Products;

import com.example.osproject.Account.Seller;
import com.example.osproject.Misc.Rating;
import com.example.osproject.Misc.Review;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private final int ID;
    private String name;
    private int image;
    private String description;
    private ArrayList<Integer> imageDescription;
    private Rating rating;
    private int quantity;
    private float price;
    private String status;
    private ArrayList<Review> reviews;

    private Seller seller;
    //Seller
    private int sold;

    public Product(int id, String name, int quantity, float price, Seller seller) {
        ID = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.seller = seller;
        rating = new Rating();
    }

    public Product(Product product, int quantity, String status){
        ID = product.getID();
        name = product.getName();
        image = product.getImage();
        description = product.getDescription();
        imageDescription = product.imageDescription;
        price = product.getPrice();
        rating = product.getRating();
        reviews = product.getReviews();
        seller = product.getSeller();
        sold = product.getSold();
        this.quantity = quantity;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getImageDescription() {
        return imageDescription;
    }

    public void addImageDescription(int imageDescription) {
        this.imageDescription.add(imageDescription);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String  status) {
        this.status = status;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public ArrayList<Review> reviews() {
        return reviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public Seller getSeller(){
        return seller;
    }

    public boolean equal(Product product){
        if (product.getName().compareTo(name) == 0){
            if (product.getSeller().getName().compareTo(seller.getName()) == 0){
                return true;
            }
        }
        return false;
    }

}
