package com.example.osproject.UI.Seller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.osproject.databinding.SellerMeBinding;
import com.example.osproject.databinding.SellerProductDashboardBinding;

public class SellerMeActivity extends AppCompatActivity {
    SellerMeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        binding = SellerMeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
