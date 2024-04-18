package com.example.osproject.LiveData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.osproject.Account.Account;

public class AccountViewModel extends ViewModel {
    private final MutableLiveData<Account> accountMutableLiveData = new MutableLiveData<Account>();

    public void setAccount(Account account) {
        accountMutableLiveData.setValue(account);
    }
    public LiveData<Account> getAccount() {
        return accountMutableLiveData;
    }
}
