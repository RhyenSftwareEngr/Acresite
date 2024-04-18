package com.example.osproject.LiveData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.osproject.Account.Account;
import com.example.osproject.Products.Product;

import java.util.ArrayList;

public class ProductListViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<Product>> prodcutsLiveData = new MutableLiveData<ArrayList<Product>>();

    public void setProducts(ArrayList<Product> products) {
        prodcutsLiveData.setValue(products);
    }
    public LiveData<ArrayList<Product>> getProducts() {
        return prodcutsLiveData;
    }
}
