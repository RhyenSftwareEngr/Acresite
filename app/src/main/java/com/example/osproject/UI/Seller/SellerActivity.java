package com.example.osproject.UI.Seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.osproject.databinding.ActivityMainBinding;
import com.example.osproject.databinding.FragmentSellerBinding;
import com.example.osproject.databinding.SellerProductDashboardBinding;

public class SellerActivity extends AppCompatActivity {

    private SellerProductDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstancec) {
        super.onCreate(savedInstancec);

        binding = SellerProductDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




    }
}