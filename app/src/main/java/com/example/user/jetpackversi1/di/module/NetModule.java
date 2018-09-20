package com.example.user.jetpackversi1.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.user.jetpackversi1.App;
import com.example.user.jetpackversi1.Util;
import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.user.jetpackversi1.Util.dbName;

@Module
public class NetModule {
    String mBaseUrl;
    Application app;


    @Provides
    AppDatabase provideAppDatabase(Application app) {
        return Room.databaseBuilder(app, AppDatabase.class, "dbMahasiswa").allowMainThreadQueries().build();
    }


    @Provides
    App provideApplication(App application){
        return  application;
    }


    public NetModule(String mBaseUrl, App app) {
        this.mBaseUrl = mBaseUrl;
        this.app=app;

    }
    @Provides
    ApiInterface provideData(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }


    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    Interceptor provideInter() {
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return localHttpLoggingInterceptor;
    }

    @Provides
    OkHttpClient provideOkHttp(Interceptor paramInterceptor)
    {
        return new OkHttpClient.Builder().addInterceptor(paramInterceptor).connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).build();
    }

    @Provides
    Retrofit provideRetrofit( OkHttpClient client)
    {
        return new Retrofit.Builder().baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    }