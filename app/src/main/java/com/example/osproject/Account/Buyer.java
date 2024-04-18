package com.example.osproject.Account;

import com.example.osproject.Misc.Address;
import com.example.osproject.Products.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Stack;

public class Buyer implements Serializable {
    private ArrayList<Product> cart;
    private ArrayList<Product> toPack;
    private ArrayList<Product> toDeliver;
    private ArrayList<Product> rate;
    private ArrayList<Product> completedOrders;
    private Address address;

    public Buyer(String region, String provinceCity, String barangay, String buildingStreet) {
        cart = new ArrayList<>();
        toPack = new ArrayList<>();
        toDeliver = new ArrayList<>();
        rate = new ArrayList<>();
        completedOrders = new ArrayList<>();
        address = new Address(region, provinceCity, barangay, buildingStreet);
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public ArrayList<Product> getToPack() {
        return toPack;
    }

    public ArrayList<Product> getToDeliver() {
        return toDeliver;
    }

    public ArrayList<Product> getRate() {
        return rate;
    }

    public ArrayList<Product> getCompletedOrders() {
        return completedOrders;
    }

    public Address getAddress() {
        return address;
    }
}
