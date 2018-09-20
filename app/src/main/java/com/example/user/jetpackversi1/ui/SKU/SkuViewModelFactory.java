package com.example.user.jetpackversi1.ui.SKU;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.Login.LoginContract;
import com.example.user.jetpackversi1.ui.Login.LoginViewModel;

import retrofit2.Retrofit;

public class SkuViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private SkuContract skuContract;
    Context application;
    AppDatabase appDatabase;

    public SkuViewModelFactory(Context application, SkuContract skuContract, AppDatabase appDatabase) {
        this.skuContract = skuContract;
        this.application=application;
        this.appDatabase=appDatabase;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return(T)new SkuViewModel(application,skuContract,appDatabase);
    }
}
