package com.example.osproject.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

import com.example.osproject.R;
import com.example.osproject.databinding.ActivityMainBinding;
import com.example.osproject.databinding.ActivityProductDetailsBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.CornerFamily;

public class ProductDetails extends AppCompatActivity {
    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Product product = (Product) getIntent().getSerializableExtra("product");
        binding.productDescription.setMovementMethod(new ScrollingMovementMethod());

        binding.productName.setText(product.getName());
        binding.productPrice.setText(Float.toString(product.getPrice()));
        binding.productDescription.setText(product.getDescription());
        binding.productRating.setText(product.getRating().toString());
        binding.sellerName.setText(product.getSeller().getName());
        binding.sellerRating.setText(product.getSeller().getRating().toString());
        binding.productImage.setImageResource(product.getImage());

        final MediaPlayer anotherOne = android.media.MediaPlayer.create(this, R.raw.another_one);
        final MediaPlayer hkViolin = android.media.MediaPlayer.create(this, R.raw.kn_violin);
        final MediaPlayer hoya = android.media.MediaPlayer.create(this, R.raw.hoyaaaa);
        binding.subQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.valueOf(String.valueOf(binding.qty.getText()))>0){
                    hkViolin.start();
                    binding.qty.setText(Integer.toString(Integer.valueOf(String.valueOf(binding.qty.getText())) - 1));
                } else
                    return;
            }
        });

        binding.addQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anotherOne.start();
                binding.qty.setText(Integer.toString(Integer.valueOf(String.valueOf(binding.qty.getText())) + 1));
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoya.start();
                finish();
            }
        });

        binding.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Product tempPrd = new Product(product, Integer.valueOf(binding.qty.getText().toString()), "cart");
                intent.putExtra("product", tempPrd);
                setResult(100, intent);
                finish();
            }
        });
    }
}