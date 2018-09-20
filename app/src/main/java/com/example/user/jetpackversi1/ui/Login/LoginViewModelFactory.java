package com.example.user.jetpackversi1.ui.Login;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.rest.ApiInterface;

import retrofit2.Retrofit;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginContract loginContract;
    Context application;
    Retrofit retrofit;
    ApiInterface apiInterface;
    AppDatabase appDatabase;

    public LoginViewModelFactory(Context application, LoginContract loginContract, ApiInterface apiInterface, AppDatabase appDatabase) {
        this.loginContract = loginContract;
        this.retrofit=retrofit;
        this.apiInterface=apiInterface;
        this.application=application;
        this.appDatabase=appDatabase;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return(T)new LoginViewModel(application,loginContract,apiInterface,appDatabase);
    }
}
