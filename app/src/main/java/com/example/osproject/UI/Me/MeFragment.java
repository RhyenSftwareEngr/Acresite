package com.example.osproject.UI.Me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osproject.Account.Seller;
import com.example.osproject.Adapter.ProductAdapter;
import com.example.osproject.Model.ProductModel;
import com.example.osproject.Products.Product;
import com.example.osproject.R;
import com.example.osproject.databinding.FragmentMeBinding;

import java.util.ArrayList;

public class MeFragment extends Fragment {

    private ArrayList<Product> products = new ArrayList<>();

    private FragmentMeBinding binding;

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            });

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeViewModel meViewModel =
                new ViewModelProvider(this).get(MeViewModel.class);

        binding = FragmentMeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.meRecycler;

        setupMeProductModels();

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        ProductAdapter productAdapter = new ProductAdapter(this, resultLauncher, this.getContext(), products);
        recyclerView.setAdapter(productAdapter);

        final TextView textView = binding.textMe;
        meViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    private void setupMeProductModels() {
        Seller slr = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            slr = new Seller("Joe", "Region 1", "Benguet, Baguio",
                    "Bakakeng Sur", "7/11");

            Seller slr1 = new Seller("Jack", "Region 1", "IDK",
                    "Basta", "Duon");

            Seller slr2 = new Seller("John", "Kahit", "Saan",
                    "Basta", "Mura");

            Seller slr3 = new Seller("Jimmy", "Sana", "perfect",
                    "score", "Ma'am Ria");

            Seller slr4 = new Seller("Jen", "Merry", "Christmas",
                    "& a Happy", "New Year!");

            Seller slr5 = new Seller("Jaizer", "Gusto", "ko",
                    "ng", "Ice Cream");

            Seller slr6 = new Seller("Jebong", "I am", "so fcking",
                    "sleepy", "and tired");

            Seller slr7 = new Seller("Jericho", "Wag", "ka",
                    "ng", "mawala");

            Seller slr8 = new Seller("Joash", "Heli", "Copter",
                    "Heli", "Copter");

            Product prd = new Product(0, "Onion", 10, 62.51F, slr);
            prd.setDescription(getString(R.string.onion_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd.setImage(R.drawable.onion);

            Product prd2 = new Product(2, "AMOGUS", 10, 694.20F, slr1);
            prd2.setDescription("yo what is up you guys right now we’re at mcdonalds, and it is currently 3 in the morning and we just found out when you come to mcdonalds at 3 in the morning, you can order the among us happy meal you guys, that’s right, you heard, me, the among us happy meal, and there’s a toy inside of among us- you can either be a crewmate, or it can be an impostor and if you guys do not know what among us is, you must be living under a rock you guys, this game is insane, ok? so you can play with a bunch of friends ok? like 8, i- i- i think it’s up to 10 people you can play with, and there’s impostors, and there’s crewmates, and pretty much the impostor is trying to sabotage the whole game and trying to win. it’s insane you guys, once again, this- this video is not sponsored at all, but this game is insane. so we got so excited guys we love the game and we found that the mcdonalds is offering an among us happy meal, AND there’s a toy inside, but supposedly, when you get this happy meal you guys, something scary and weird with the impostor. now i don’t really believe it, but these videos i’ve been seeing on youtube have been insane, so that’s why we’re here right now, we’re gonna go through the drive through, and we’re gonna order the among us happy meal. But i need EVERYONE to like this video if you’re excited, ok? like this video with your knuckles right now, just smash, hit the like button, SUPER HARD you guys, on the count of 3 seconds i wanna see what you guys can do cuz i can’t do it, and if cole can’t do it, no one could like this video with their knuckles so let’s see if you guys can do it in 3 seconds. 3, 2, 1. OH HO!");
            prd2.setImage(R.drawable.amogus);

            Product prd3 = new Product(3,"Broccoli", 3, 320.69F, slr2);
            prd3.setDescription(getString(R.string.broc_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd3.setImage(R.drawable.broc);

            Product prd4 = new Product(4,"Chili", 2, 280.00F, slr3);
            prd4.setDescription(getString(R.string.chili_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd4.setImage(R.drawable.chili);

            Product prd5 = new Product(5,"Eggplant", 2, 40.00F, slr4);
            prd5.setDescription(getString(R.string.eggplant_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd5.setImage(R.drawable.eggplant);

            Product prd6 = new Product(6,"Apple", 2, 35.00F, slr5);
            prd6.setDescription(getString(R.string.apple_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd6.setImage(R.drawable.apple);

            Product prd7 = new Product(7,"Banana", 2, 40.00F, slr6);
            prd7.setDescription(getString(R.string.banana_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd7.setImage(R.drawable.banana);

            Product prd8 = new Product(8,"Cabbage", 2, 60.00F, slr7);
            prd8.setDescription(getString(R.string.cabbage_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd8.setImage(R.drawable.cabbage);


            Product prd9 = new Product(9,"Carrot", 2, 50.00F, slr8);
            prd9.setDescription(getString(R.string.carrot_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
            prd9.setImage(R.drawable.carrot);


            products.add(prd);
            products.add(prd2);
            products.add(prd3);
            products.add(prd4);
            products.add(prd5);
            products.add(prd6);
            products.add(prd7);
            products.add(prd8);
            products.add(prd9);

        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}