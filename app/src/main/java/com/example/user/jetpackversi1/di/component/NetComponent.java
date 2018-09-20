package com.example.user.jetpackversi1.di.component;

import android.app.Application;
import android.content.Context;

import com.example.user.jetpackversi1.App;
import com.example.user.jetpackversi1.di.builder.ActivityBuilder;
import com.example.user.jetpackversi1.di.module.AppModule;
import com.example.user.jetpackversi1.di.module.NetModule;
import com.example.user.jetpackversi1.ui.Login.Login;
import com.example.user.jetpackversi1.ui.MainActivity;
import com.example.user.jetpackversi1.ui.SKU.SkuForm;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class,ActivityBuilder.class})
public interface NetComponent {
    void inject(Login login);
    void inject(MainActivity mainActivity);
    void inject(SkuForm skuForm);
}
