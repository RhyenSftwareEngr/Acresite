package com.example.osproject.UI.Cart;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.osproject.Account.Account;
import com.example.osproject.Adapter.CartProductAdapter;
import com.example.osproject.Adapter.ProductAdapter;
import com.example.osproject.Interfaces.OnDeleteListener;
import com.example.osproject.LiveData.AccountViewModel;
import com.example.osproject.Products.Product;
import com.example.osproject.R;
import com.example.osproject.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class Cart extends AppCompatActivity implements OnDeleteListener {
    ActivityCartBinding binding;
    Account mainAccount;
    ArrayList<ArrayList<Object>> toDelete = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainAccount = (Account) getIntent().getExtras().get("account");

        RecyclerView recyclerView = binding.cartRecycler;
        CartProductAdapter cartProductAdapter = new CartProductAdapter(binding, this, mainAccount.getBuyerAccount().getCart());
        recyclerView.setAdapter(cartProductAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MediaPlayer errorSound = android.media.MediaPlayer.create(this, R.raw.erro);
        final MediaPlayer wow = android.media.MediaPlayer.create(this, R.raw.wow_2);
        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorSound.start();
                Intent intent = new Intent();
                intent.putExtra("mainAccount", mainAccount);
                setResult(101, intent);
                finish();
            }
        });

        binding.cartProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wow.start();
                finish();
            }
        });

        binding.cartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (ArrayList<Object> p: toDelete) {
                    Product prd = (Product) p.get(0);
                    Integer position = (Integer) p.get(1);
                    Integer size = (Integer) p.get(2);
                    mainAccount.getBuyerAccount().getCart().remove(prd);
                    toDelete.remove(prd);
                    cartProductAdapter.notifyItemRemoved(position);
                    cartProductAdapter.notifyItemRangeChanged(position, size);
                }
            }
        });
    }

    @Override
    public void onAdd(Product product, Integer position, Integer size) {
        ArrayList<Object> temp = new ArrayList<>();
        temp.add(product);
        temp.add(position);
        temp.add(size);
        toDelete.add(temp);
    }
    @Override
    public void onRemove(Product product, Integer position, Integer size){
        toDelete.remove(product);
    }
}