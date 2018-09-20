package com.example.user.jetpackversi1.dao;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class bindingAdapterclass {
    private static AppDatabase appDatabase;
    public bindingAdapterclass(AppDatabase appDatabase){
        this.appDatabase=appDatabase;
    }
    @BindingAdapter(value = {"skuSid"})
    public static void skuSid(TextView textView, String skuSid) {
        String name=appDatabase.skuDao().getSkuName(skuSid);
        textView.setText(name);
    }
}
