package com.example.user.jetpackversi1.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.Login.LoginContract;
import com.example.user.jetpackversi1.ui.Login.LoginViewModel;

import retrofit2.Retrofit;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    Context application;
    Retrofit retrofit;
    ApiInterface apiInterface;
    AppDatabase appDatabase;
    MainContract mainContract;

    public MainViewModelFactory(Context application,MainContract mainContract, ApiInterface apiInterface, AppDatabase appDatabase) {

        this.apiInterface=apiInterface;
        this.application=application;
        this.appDatabase=appDatabase;
        this.mainContract=mainContract;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return(T)new MainActivityModel(application,mainContract,apiInterface,appDatabase);
    }
}
