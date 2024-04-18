package com.example.osproject.UI.Seller;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SellerViewModel extends ViewModel {

    private static MutableLiveData<String> mText;

    public SellerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Create Seller Account");
    }

    public static LiveData<String> getText() {
        return mText;
    }
}