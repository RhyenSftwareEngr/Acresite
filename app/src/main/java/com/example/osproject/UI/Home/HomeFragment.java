package com.example.osproject.UI.Home;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osproject.Account.Account;
import com.example.osproject.Account.Seller;
import com.example.osproject.Adapter.ProductAdapter;
import com.example.osproject.LiveData.AccountViewModel;
import com.example.osproject.LiveData.ProductListViewModel;
import com.example.osproject.MainActivity;
import com.example.osproject.Model.ProductModel;
import com.example.osproject.Products.Product;
import com.example.osproject.R;
import com.example.osproject.UI.Cart.Cart;
import com.example.osproject.databinding.FragmentHomeBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Account mainAccount;
    private ArrayList<Product> products;
    private AccountViewModel accountViewModel;
    private ProductListViewModel productsViewModel;

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null) {
                        System.out.println("--------------------------Success result " + result.getResultCode());
                        if (result.getResultCode() == 100) {
                            Product prd = (Product) result.getData().getExtras().get("product");
                            boolean tempBool = false;
                            for (Product product: mainAccount.getBuyerAccount().getCart()) {
                                if (product.equal(prd)) {
                                    product.setQuantity(product.getQuantity() + prd.getQuantity());
                                    tempBool = true;
                                }
                            }
                            if (!tempBool) {
                                mainAccount.getBuyerAccount().getCart().add(prd);
                            }
                            accountViewModel.setAccount(mainAccount);
                            Toast.makeText(getContext().getApplicationContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                        } else if (result.getResultCode() == 101) {
                            mainAccount = (Account) result.getData().getExtras().get("mainAccount");
                        }
                    } else {
                        System.out.println("EMPTY RESULT!");
                    }
                }
            });

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        accountViewModel = new ViewModelProvider(requireActivity()).get(AccountViewModel.class);
        accountViewModel.getAccount().observe(getViewLifecycleOwner(), account -> {
            mainAccount = account;
        });

        productsViewModel = new ViewModelProvider(requireActivity()).get(ProductListViewModel.class);
        productsViewModel.getProducts().observe(getViewLifecycleOwner(), products1 -> {
            products = products1;
            RecyclerView recyclerView = binding.homeRecyclerView;
            ProductAdapter productAdapter = new ProductAdapter(this, resultLauncher, this.getContext(), products);
            recyclerView.setAdapter(productAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

            final MediaPlayer vineBoom = android.media.MediaPlayer.create(this.getContext(), R.raw.vine_boom);
            binding.cartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vineBoom.start();
                    Intent intent =new Intent(getContext(), Cart.class);
                    intent.putExtra("account", mainAccount);
                    resultLauncher.launch(intent);
                }
            });
        });

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText)


        return root;
    }

    private void setupProductModels() { //Kulang pa ng Rating
        Seller slr = new Seller("Joe", "Region 1", "Benguet, Baguio",
                "Bakakeng Sur", "7/11");

        Seller slr1 = new Seller("Jack", "Region 1", "IDK",
                "Basta", "Duon");

        Seller slr2 = new Seller("John", "Kahit", "Saan",
                "Basta", "Mura");

        Product prd = new Product(0, "Onion", 10, 62.51F, slr);
        prd.setDescription(getString(R.string.flavor_text));
        prd.setImage(R.drawable.onion);

        Product prd2 = new Product(1, "AMOGUS", 10, 694.20F, slr1);
        prd2.setDescription("yo what is up you guys right now we’re at mcdonalds, and it is currently 3 in the morning and we just found out when you come to mcdonalds at 3 in the morning, you can order the among us happy meal you guys, that’s right, you heard, me, the among us happy meal, and there’s a toy inside of among us- you can either be a crewmate, or it can be an impostor and if you guys do not know what among us is, you must be living under a rock you guys, this game is insane, ok? so you can play with a bunch of friends ok? like 8, i- i- i think it’s up to 10 people you can play with, and there’s impostors, and there’s crewmates, and pretty much the impostor is trying to sabotage the whole game and trying to win. it’s insane you guys, once again, this- this video is not sponsored at all, but this game is insane. so we got so excited guys we love the game and we found that the mcdonalds is offering an among us happy meal, AND there’s a toy inside, but supposedly, when you get this happy meal you guys, something scary and weird with the impostor. now i don’t really believe it, but these videos i’ve been seeing on youtube have been insane, so that’s why we’re here right now, we’re gonna go through the drive through, and we’re gonna order the among us happy meal. But i need EVERYONE to like this video if you’re excited, ok? like this video with your knuckles right now, just smash, hit the like button, SUPER HARD you guys, on the count of 3 seconds i wanna see what you guys can do cuz i can’t do it, and if cole can’t do it, no one could like this video with their knuckles so let’s see if you guys can do it in 3 seconds. 3, 2, 1. OH HO!");
        prd2.setImage(R.drawable.amogus);

        Product prd3 = new Product(2,"Broccoli", 3, 512.69F, slr2);
        prd3.setDescription(getString(R.string.flavor_text));
        prd3.setImage(R.drawable.broc);

        Product prd4 = new Product(3,"Chili", 2, 120.69F, slr);
        prd4.setDescription(getString(R.string.flavor_text));
        prd4.setImage(R.drawable.chili);

        Product prd5 = new Product(4,"Eggplant", 2, 26.57F, slr);
        prd5.setDescription(getString(R.string.flavor_text));
        prd5.setImage(R.drawable.eggplant);

        products.add(prd);
        products.add(prd2);
        products.add(prd3);
        products.add(prd4);
        products.add(prd5);
    }

    public Account getMainAccount() {
        return mainAccount;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        accountViewModel.setAccount(mainAccount);
        productsViewModel.setProducts(products);
    }
}