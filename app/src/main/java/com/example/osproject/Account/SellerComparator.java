package com.example.osproject.Account;

import com.example.osproject.Products.Product;

import java.io.Serializable;
import java.util.Comparator;

public class SellerComparator implements Comparator<Product>, Serializable {
    @Override
    public int compare(Product product, Product t1) {
        return product.getName().compareTo(t1.getName());
    }
}
