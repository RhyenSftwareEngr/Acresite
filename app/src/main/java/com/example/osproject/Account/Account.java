package com.example.osproject.Account;

import java.io.Serializable;
import java.util.UUID;

public class Account implements Serializable {
    private final String ID;
    private String email;
    private String number;
    private String password;
    private String name;
    private int image;
    private Buyer buyerAccount;
    private Seller sellerAccount;

    public Account(String email, String number, String password, String name) {
        ID = UUID.randomUUID().toString();
        this.email = email;
        this.number = number;
        this.password = password;
        this.name = name;
        buyerAccount = new Buyer("Region 1", "Benguet, Baguio",
                "Bakakeng North", "Amogus Building");
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public Buyer getBuyerAccount() {
        return buyerAccount;
    }

    public Seller getSellerAccount() {
        return sellerAccount;
    }
}
