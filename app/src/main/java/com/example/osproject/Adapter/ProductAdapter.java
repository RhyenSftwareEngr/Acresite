package com.example.osproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osproject.Model.ProductModel;
import com.example.osproject.Products.Product;
import com.example.osproject.Products.ProductDetails;
import com.example.osproject.R;
import com.example.osproject.UI.Home.HomeFragment;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Fragment fragment;
    private Context context;
    private ArrayList<Product> products;
    ActivityResultLauncher<Intent> resultLauncher;

    public ProductAdapter (ActivityResultLauncher<Intent> resultLauncher, Context context, ArrayList<Product> products) {
        this.resultLauncher = resultLauncher;
        this.context = context;
        this.products = products;
    }

    public ProductAdapter(Fragment fragment, ActivityResultLauncher<Intent> resultLauncher, Context context, ArrayList<Product> products){
        this.fragment = fragment;
        this.resultLauncher = resultLauncher;
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This methods inflates the layout (Giving look to rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_recycler_view_row, parent, false);
        return new ProductAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        // Assigning values to the views we created in the home_recycler_view_row layout file
        // based on the position of the recycler view.
        int pos = position;


        holder.productName.setText(products.get(position).getName());
        holder.seller.setText(products.get(position).getSeller().getName());
        holder.productPrice.setText(Float.toString(products.get(position).getPrice()));
        holder.productImage.setImageResource(products.get(position).getImage());
        holder.productRating.setText(products.get(position).getRating().toString());
        holder.productCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetails.class);
                intent.putExtra("product", products.get(pos));
                resultLauncher.launch(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // The recycler view gets the amount of items in your array list that you want displayed
        return products.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // Grabs the view from the home_recycler_view_row layout file

        ImageView productImage;
        TextView productName, seller, productPrice, productRating;
        CardView productCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            seller = itemView.findViewById(R.id.productSeller);
            productPrice = itemView.findViewById(R.id.productPrice);
            productRating = itemView.findViewById(R.id.productRating);
            productCardView = itemView.findViewById(R.id.productCardView);
        }
    }
}
