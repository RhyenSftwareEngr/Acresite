package com.example.osproject.Model;

public class ProductModel {
    String productName;
    String sellerName;
    String price;
    String ratings;
    int image;

    public ProductModel(String productName, String sellerName,
                        String price, float rating, int image) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%2.1f", rating));
        sb.append("/5 ⭐");
        this.productName = productName;
        this.sellerName = sellerName;
        this.price = price;
        this.ratings = sb.toString();
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getRatings() {
        return ratings;
    }
}
