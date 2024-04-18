package com.example.osproject.UI.Seller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osproject.Adapter.ProductAdapter;
import com.example.osproject.UI.Me.MeViewModel;
import com.example.osproject.databinding.FragmentMeBinding;
import com.example.osproject.databinding.FragmentSellerBinding;

public class SellerFragment extends Fragment {
    FragmentSellerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeViewModel meViewModel =
                new ViewModelProvider(this).get(MeViewModel.class);

        binding = FragmentSellerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        final Button button = binding.button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SellerActivity.class);
                startActivity(intent);
            }
        });
        return root;


    }
}
