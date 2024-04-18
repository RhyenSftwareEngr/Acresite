package com.example.osproject.Interfaces;

import com.example.osproject.Products.Product;

public interface OnDeleteListener {
    void onAdd(Product product, Integer position, Integer size);
    void onRemove(Product product, Integer position, Integer size);
}
