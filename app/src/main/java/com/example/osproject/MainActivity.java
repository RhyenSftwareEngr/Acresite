package com.example.osproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.osproject.Account.Account;
import com.example.osproject.Account.Seller;
import com.example.osproject.LiveData.AccountViewModel;
import com.example.osproject.LiveData.ProductListViewModel;
import com.example.osproject.Products.Product;
import com.example.osproject.Products.ProductDetails;
import com.example.osproject.UI.Cart.Cart;
import com.example.osproject.UI.Home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.osproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AccountViewModel accountViewModel;
    private ProductListViewModel productsViewModel;
    private ArrayList<Product> products;
    Account mainAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createAccount();
        createProducts();

        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        accountViewModel.setAccount(mainAccount);
        accountViewModel.getAccount().observe(this, account -> {
            mainAccount = account;
        });

        productsViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        productsViewModel.setProducts(products);
        productsViewModel.getProducts().observe(this, products -> {
            this.products = products;
        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_orders, R.id.navigation_me)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private void createAccount() {
        mainAccount = new Account("test@gmail.com", "09123456789", "test", "Sussus Amogus");
    }

    private void createProducts() {
        products = new ArrayList<>();

        Seller slr = new Seller("Joe", "Region 1", "Benguet, Baguio",
                "Bakakeng Sur", "7/11");
        slr.getRating().addRating(4);
        slr.getRating().addRating(5);
        slr.getRating().addRating(4);
        slr.getRating().addRating(4);


        Seller slr1 = new Seller("Jack", "Region 1", "IDK",
                "Basta", "Duon");
        slr1.getRating().addRating(4);
        slr1.getRating().addRating(5);
        slr1.getRating().addRating(4);
        slr1.getRating().addRating(4);

        Seller slr2 = new Seller("John", "Kahit", "Saan",
                "Basta", "Mura");
        slr2.getRating().addRating(5);
        slr2.getRating().addRating(5);
        slr2.getRating().addRating(5);
        slr2.getRating().addRating(5);

        Seller slr3 = new Seller("Jimmy", "Sana", "perfect",
                "score", "Ma'am Ria");
        slr3.getRating().addRating(4);
        slr3.getRating().addRating(4);
        slr3.getRating().addRating(4);
        slr3.getRating().addRating(4);

        Seller slr4 = new Seller("Jen", "Merry", "Christmas",
                "& a Happy", "New Year!");
        slr4.getRating().addRating(4);
        slr4.getRating().addRating(5);
        slr4.getRating().addRating(4);
        slr4.getRating().addRating(5);

        Seller slr5 = new Seller("Jaizer", "Gusto", "ko",
                "ng", "Ice Cream");
        slr5.getRating().addRating(4);
        slr5.getRating().addRating(5);
        slr5.getRating().addRating(4);
        slr5.getRating().addRating(1);

        Seller slr6 = new Seller("Jebong", "I am", "so fcking",
                "sleepy", "and tired");
        slr6.getRating().addRating(4);
        slr6.getRating().addRating(5);
        slr6.getRating().addRating(4);
        slr6.getRating().addRating(2);

        Seller slr7 = new Seller("Jericho", "Wag", "ka",
                "ng", "mawala");
        slr7.getRating().addRating(4);
        slr7.getRating().addRating(5);
        slr7.getRating().addRating(4);
        slr7.getRating().addRating(1);

        Seller slr8 = new Seller("Joash", "Heli", "Copter",
                "Heli", "Copter");
        slr8.getRating().addRating(4);
        slr8.getRating().addRating(5);
        slr8.getRating().addRating(4);
        slr8.getRating().addRating(1);

        Seller slr9 = new Seller("Julius", "Pabuhat", "sa",
                "valo", "boss");
        slr9.getRating().addRating(4);
        slr9.getRating().addRating(5);
        slr9.getRating().addRating(4);
        slr9.getRating().addRating(1);

        Seller slr10 = new Seller("Jeduard", "get a", "bucket",
                "and a mop", "for my...");
        slr10.getRating().addRating(4);
        slr10.getRating().addRating(5);
        slr10.getRating().addRating(2);
        slr10.getRating().addRating(4);

        Seller slr11 = new Seller("Joger", "wala", "na",
                "ako", "maisip");
        slr11.getRating().addRating(4);
        slr11.getRating().addRating(5);
        slr11.getRating().addRating(4);
        slr11.getRating().addRating(5);

        Seller slr12 = new Seller("Jhyen", "AHHHHHH", "FCKKKK",
                "DAMNN", "SHT");
        slr12.getRating().addRating(4);
        slr12.getRating().addRating(5);
        slr12.getRating().addRating(4);
        slr12.getRating().addRating(5);

        Seller slr13 = new Seller("Legit Seller", "somewhere", "basta",
                "ikaw bahala", "saan");
        slr13.getRating().addRating(4);
        slr13.getRating().addRating(5);
        slr13.getRating().addRating(4);
        slr13.getRating().addRating(2);

        Seller slr14 = new Seller("Archetect", "legit talaga", "idk",
                "wooo", "lol");
        slr14.getRating().addRating(4);
        slr14.getRating().addRating(5);
        slr14.getRating().addRating(4);
        slr14.getRating().addRating(3);

        Seller slr15 = new Seller("Kanon", "Rin", "Suzuka",
                "Mizyu", "ATARASHI GAKKO");
        slr15.getRating().addRating(4);
        slr15.getRating().addRating(5);
        slr15.getRating().addRating(1);
        slr15.getRating().addRating(4);

        Seller slr16 = new Seller("Juigi", "Jario", "Jowser",
                "Jeach", "Joad");
        slr16.getRating().addRating(4);
        slr16.getRating().addRating(5);
        slr16.getRating().addRating(4);
        slr16.getRating().addRating(2);

        Product prd = new Product(0, "Onion", 10, 62.51F, slr);
        prd.setDescription(getString(R.string.onion_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd.getRating().addRating(3);
        prd.getRating().addRating(4);
        prd.getRating().addRating(3);
        prd.setImage(R.drawable.onion);

        Product prd2 = new Product(2, "AMOGUS", 10, 694.20F, slr1);
        prd2.setDescription("yo what is up you guys right now we’re at mcdonalds, and it is currently 3 in the morning and we just found out when you come to mcdonalds at 3 in the morning, you can order the among us happy meal you guys, that’s right, you heard, me, the among us happy meal, and there’s a toy inside of among us- you can either be a crewmate, or it can be an impostor and if you guys do not know what among us is, you must be living under a rock you guys, this game is insane, ok? so you can play with a bunch of friends ok? like 8, i- i- i think it’s up to 10 people you can play with, and there’s impostors, and there’s crewmates, and pretty much the impostor is trying to sabotage the whole game and trying to win. it’s insane you guys, once again, this- this video is not sponsored at all, but this game is insane. so we got so excited guys we love the game and we found that the mcdonalds is offering an among us happy meal, AND there’s a toy inside, but supposedly, when you get this happy meal you guys, something scary and weird with the impostor. now i don’t really believe it, but these videos i’ve been seeing on youtube have been insane, so that’s why we’re here right now, we’re gonna go through the drive through, and we’re gonna order the among us happy meal. But i need EVERYONE to like this video if you’re excited, ok? like this video with your knuckles right now, just smash, hit the like button, SUPER HARD you guys, on the count of 3 seconds i wanna see what you guys can do cuz i can’t do it, and if cole can’t do it, no one could like this video with their knuckles so let’s see if you guys can do it in 3 seconds. 3, 2, 1. OH HO!");
        prd2.setImage(R.drawable.amogus);
        prd2.getRating().addRating(3);
        prd2.getRating().addRating(4);
        prd2.getRating().addRating(1);

        Product prd3 = new Product(3,"Broccoli", 3, 320.69F, slr2);
        prd3.setDescription(getString(R.string.broc_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd3.setImage(R.drawable.broc);
        prd3.getRating().addRating(3);
        prd3.getRating().addRating(4);
        prd3.getRating().addRating(2);

        Product prd4 = new Product(4,"Chili", 2, 280.00F, slr3);
        prd4.setDescription(getString(R.string.chili_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd4.setImage(R.drawable.chili);
        prd4.getRating().addRating(3);
        prd4.getRating().addRating(4);
        prd4.getRating().addRating(1);

        Product prd5 = new Product(5,"Eggplant", 2, 40.00F, slr4);
        prd5.setDescription(getString(R.string.eggplant_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd5.setImage(R.drawable.eggplant);
        prd5.getRating().addRating(3);
        prd5.getRating().addRating(4);
        prd5.getRating().addRating(4);

        Product prd6 = new Product(6,"Apple", 2, 35.00F, slr5);
        prd6.setDescription(getString(R.string.apple_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd6.setImage(R.drawable.apple);
        prd6.getRating().addRating(1);
        prd6.getRating().addRating(4);
        prd6.getRating().addRating(5);

        Product prd7 = new Product(7,"Banana", 2, 40.00F, slr6);
        prd7.setDescription(getString(R.string.banana_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd7.setImage(R.drawable.banana);
        prd7.getRating().addRating(3);
        prd7.getRating().addRating(4);
        prd7.getRating().addRating(4);

        Product prd8 = new Product(8,"Cabbage", 2, 60.00F, slr7);
        prd8.setDescription(getString(R.string.cabbage_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd8.setImage(R.drawable.cabbage);
        prd8.getRating().addRating(4);
        prd8.getRating().addRating(4);
        prd8.getRating().addRating(5);


        Product prd9 = new Product(9,"Carrot", 2, 50.00F, slr8);
        prd9.setDescription(getString(R.string.carrot_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd9.setImage(R.drawable.carrot);
        prd9.getRating().addRating(3);
        prd9.getRating().addRating(4);
        prd9.getRating().addRating(5);


        Product prd10 = new Product(10,"Corn", 2, 85.92F, slr9);
        prd10.setDescription(getString(R.string.corn_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd10.setImage(R.drawable.corn);
        prd10.getRating().addRating(3);
        prd10.getRating().addRating(4);
        prd10.getRating().addRating(5);


        Product prd11 = new Product(11,"Egg", 2, 130.78F, slr10);
        prd11.setDescription(getString(R.string.egg_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd11.setImage(R.drawable.egg);
        prd11.getRating().addRating(3);
        prd11.getRating().addRating(4);
        prd11.getRating().addRating(2);


        Product prd12 = new Product(12,"Garlic", 2, 210.00F, slr11);
        prd12.setDescription(getString(R.string.garlic_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd12.setImage(R.drawable.garlic);
        prd12.getRating().addRating(3);
        prd12.getRating().addRating(4);
        prd12.getRating().addRating(1);


        Product prd13 = new Product(13,"Orange", 2, 25.00F, slr12);
        prd13.setDescription(getString(R.string.orange_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd13.setImage(R.drawable.orange);
        prd13.getRating().addRating(4);
        prd13.getRating().addRating(4);
        prd13.getRating().addRating(5);


        Product prd14 = new Product(14,"Potatoes", 2, 45.00F, slr13);
        prd14.setDescription(getString(R.string.potatoes_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd14.setImage(R.drawable.potatoes);
        prd14.getRating().addRating(3);
        prd14.getRating().addRating(3);
        prd14.getRating().addRating(5);


        Product prd15 = new Product(15,"Rice", 2, 78.34F, slr14);
        prd15.setDescription(getString(R.string.rice_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd15.setImage(R.drawable.rice);
        prd15.getRating().addRating(3);
        prd15.getRating().addRating(1);
        prd15.getRating().addRating(5);


        Product prd16 = new Product(16,"Tomatoes", 2, 60.00F, slr15);
        prd16.setDescription(getString(R.string.tomatoes_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd16.setImage(R.drawable.tomatoes);
        prd16.getRating().addRating(3);
        prd16.getRating().addRating(2);
        prd16.getRating().addRating(5);


        Product prd17 = new Product(17,"Mango", 2, 90.00F, slr16);
        prd17.setDescription(getString(R.string.mango_text)+ "\nHarvest Date: " + "\nEstimated Expiry: ");
        prd17.setImage(R.drawable.mango);
        prd17.getRating().addRating(5);
        prd17.getRating().addRating(4);
        prd17.getRating().addRating(5);


        products.add(prd);
        products.add(prd2);
        products.add(prd3);
        products.add(prd4);
        products.add(prd5);
        products.add(prd6);
        products.add(prd7);
        products.add(prd8);
        products.add(prd9);
        products.add(prd10);
        products.add(prd11);
        products.add(prd12);
        products.add(prd13);
        products.add(prd14);
        products.add(prd15);
        products.add(prd16);
        products.add(prd17);
    }

}