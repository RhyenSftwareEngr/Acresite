package com.example.osproject.Account;

import com.example.osproject.Misc.Address;
import com.example.osproject.Misc.Rating;
import com.example.osproject.Products.Product;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Seller implements Serializable {
    private String name;
    private Rating rating;
    private PriorityQueue<Product> inventory;
    private Queue<Product> toPack;
    private Queue<Product> toShip;
    private Deque<Product> completedOrders;
    private Address address;

    public Seller(String name, String region, String provinceCity, String barangay, String buildingStreet) {
        this.name = name;
        rating = new Rating();
        inventory = new PriorityQueue<Product>(new SellerComparator());

        toPack = new LinkedList<>();
        toShip = new LinkedList<>();
        completedOrders = new LinkedList<>();
        address = new Address(region, provinceCity, barangay, buildingStreet);
    }

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public PriorityQueue<Product> getInventory() {
        return inventory;
    }

    public Queue<Product> getToPack() {
        return toPack;
    }

    public Queue<Product> getToShip() {
        return toShip;
    }

    public Deque<Product> getCompletedOrders() {
        return completedOrders;
    }

    public Address getAddress() {
        return address;
    }
}
