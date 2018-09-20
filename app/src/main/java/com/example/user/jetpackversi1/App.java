package com.example.user.jetpackversi1;

import android.app.Application;

import com.example.user.jetpackversi1.di.component.DaggerNetComponent;
import com.example.user.jetpackversi1.di.component.NetComponent;
import com.example.user.jetpackversi1.di.module.AppModule;
import com.example.user.jetpackversi1.di.module.NetModule;


public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://x-locate.com/carshareapi/",this))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}