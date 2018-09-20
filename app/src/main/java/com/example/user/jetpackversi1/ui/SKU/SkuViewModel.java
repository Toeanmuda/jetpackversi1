package com.example.user.jetpackversi1.ui.SKU;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.Datasku;

import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.data.model.UserModel;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.Login.Login;
import com.example.user.jetpackversi1.ui.Login.LoginContract;

import java.util.List;

public class SkuViewModel extends ViewModel {

    private Datasku datasku;
    private AppDatabase appDatabase;
    private final LiveData<List<Datasku>> loaddata;
    Context mcontext;

    SkuContract skuContract;


    public SkuViewModel(Context application, SkuContract skuContract, AppDatabase appDatabase) {

        this.mcontext=application;
        this.appDatabase=appDatabase;
        this.skuContract=skuContract;
        loaddata=appDatabase.dataskuDao().loadAll();
    }

    public LiveData<List<Datasku>> getIni() {
        return loaddata;
    }

}
