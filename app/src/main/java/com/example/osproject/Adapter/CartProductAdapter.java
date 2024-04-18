package com.example.osproject.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osproject.Products.Product;
import com.example.osproject.R;
import com.example.osproject.UI.Cart.Cart;
import com.example.osproject.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<Product> products;
    private ActivityCartBinding activityCartBinding;
    private ArrayList<Product> checked = new ArrayList<>();

    private float totalPrice = 0F;

    public CartProductAdapter (ActivityCartBinding activityCartBinding, Context context, ArrayList<Product> products) {
        this.activityCartBinding = activityCartBinding;
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public CartProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This methods inflates the layout (Giving look to rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_recycler_view_row, parent, false);
        return new CartProductAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductAdapter.MyViewHolder holder, int position) {
        // Assigning values to the views we created in the home_recycler_view_row layout file
        // based on the position of the recycler view.

        final MediaPlayer mp = MediaPlayer.create(context, R.raw.vine_boom);

        holder.productName.setText(products.get(position).getName());
        holder.seller.setText(products.get(position).getSeller().getName());
        holder.productPrice.setText(Float.toString(products.get(position).getPrice()));
        holder.productImage.setImageResource(products.get(position).getImage());
        holder.productRating.setText(products.get(position).getRating().toString());
        holder.prodcutQuantity.setText(Integer.toString(products.get(position).getQuantity()));

        activityCartBinding.cartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Product p : checked) {
                    int pos = products.indexOf(p);
                    totalPrice -= (float) p.getPrice() * p.getQuantity();
                    products.remove(p);
                }
                checked = new ArrayList<>();
                activityCartBinding.cartFinalprice.setText(String.format("%.2f", totalPrice));
                notifyDataSetChanged();
            }
        });

        holder.productCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                if (holder.cartCheckBox.isChecked()) {
                    holder.cartCheckBox.setChecked(false);
                } else {
                    holder.cartCheckBox.setChecked(true);
                }
            }
        });

        holder.cartCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    totalPrice += products.get(position).getPrice() * (float) products.get(position).getQuantity();
                    activityCartBinding.cartFinalprice.setText(String.format("%.2f",totalPrice));
                    checked.add(products.get(position));
                } else {
                    totalPrice -= products.get(position).getPrice() * (float) products.get(position).getQuantity();
                    activityCartBinding.cartFinalprice.setText(String.format("%.2f",totalPrice));
                    checked.remove(products.get(position));
                }
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
        TextView productName, seller, productPrice, productRating, prodcutQuantity;
        CardView productCardView;
        CheckBox cartCheckBox;
        ImageButton cartDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.cartProductImage);
            productName = itemView.findViewById(R.id.cartProductName);
            seller = itemView.findViewById(R.id.cartProductSeller);
            productPrice = itemView.findViewById(R.id.cartProductPrice);
            productRating = itemView.findViewById(R.id.cartProductRating);
            productCardView = itemView.findViewById(R.id.cartProductCardView);
            prodcutQuantity = itemView.findViewById(R.id.cartProductQuantity);
            cartCheckBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
